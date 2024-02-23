package cn.cxnxs.scheduler.quartz.jobs;


import cn.cxnxs.scheduler.entity.ScheduleAgent;
import cn.cxnxs.scheduler.entity.ScheduleAgentLogs;
import cn.cxnxs.scheduler.entity.ScheduleEvents;
import cn.cxnxs.scheduler.enums.RunState;
import cn.cxnxs.scheduler.quartz.JobSupport;
import cn.cxnxs.scheduler.quartz.TaskDetail;
import cn.cxnxs.scheduler.quartz.TaskScheduler;
import cn.cxnxs.scheduler.service.AgentServiceImpl;
import cn.cxnxs.scheduler.service.EventsServiceImpl;
import cn.cxnxs.scheduler.vo.AgentTypeVo;
import cn.cxnxs.scheduler.vo.AgentVo;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>定时任务类</p>
 *
 * @author mengjinyuan
 * @date 2021-02-01 22:53
 **/
public class RunningAgentJob extends QuartzJobBean {

    @Autowired
    private AgentServiceImpl agentService;

    @Autowired
    private EventsServiceImpl eventsService;

    @Autowired
    private TaskScheduler taskScheduler;

    @Autowired
    private JobSupport jobSupport;

    private static final Logger logger = LoggerFactory.getLogger(RunningAgentJob.class);

    /**
     * 代理信息id
     */
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 定时任务执行入口
     *
     * @param jobExecutionContext 上下文信息
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        AgentVo agentVo = agentService.getAgentById(id);
        ScheduleAgent agent = new ScheduleAgent();
        agent.setId(id);
        agent.setUpdatedAt(LocalDateTime.now());
        agent.setLastCheckAt(LocalDateTime.now());
        agent.updateById();
        if (Objects.equals(agentVo.getState(), AgentVo.AgentState.DISABLE.getCode())) {
            // 任务已关闭或者暂停
            taskScheduler.pauseJob(new TaskDetail(agentVo.getName(), agentVo.getAgentType().getAgentTypeName(), agentVo.getName(), agentVo.getAgentType().getAgentTypeName()));
            return;
        }
        try {
            //获取来源代理
            List<AgentVo> sourceAgents = agentVo.getSourceAgents();
            logger.info("------开始运行:{}，数据来源：{}------", agentVo.getName(), sourceAgents.stream().map(AgentVo::getName).collect(Collectors.toList()));

            if (CollectionUtils.isEmpty(sourceAgents)) {
                // 无输入数据源来源直接运行
                jobSupport.runTask(agentVo, null);
            } else {
                // 假如不是立即传播的话，先检查数据源任务是不是都执行完成了，否则等待数据准备完成才能执行
                if (!agentVo.getPropagateImmediately()
                        && sourcesAreRunning(sourceAgents.stream().map(AgentVo::getId).collect(Collectors.toList()))) {
                    return;
                }
                List<Integer> sourceAgentsIdList = sourceAgents.stream().map(AgentVo::getId).collect(Collectors.toList());
                List<ScheduleEvents> events = getSourceEvents(sourceAgentsIdList, agentVo);
                jobSupport.runTask(agentVo, events);
            }
        } catch (Exception e) {
            logger.error("定时任务执行失败", e);
        }
    }



    /**
     * 判断数据源是否没有正在运行的，停止了数据准备好了，才可以运行
     *
     * @param sourceIds 数据源任务id
     */
    public Boolean sourcesAreRunning(List<Integer> sourceIds) {
        Integer count = new ScheduleAgentLogs().selectCount(Wrappers.lambdaQuery(ScheduleAgentLogs.class)
                .in(ScheduleAgentLogs::getAgentId, sourceIds).eq(ScheduleAgentLogs::getState, RunState.WORKING));
        if (count > 0) {
            logger.info("数据源有任务正在执行中，本次任务取消");
            return true;
        }
        return false;
    }

    /**
     * 分页获取数据源数据
     *
     * @param sourceIds
     * @param agentVo
     * @return
     */
    public List<ScheduleEvents> getSourceEvents(List<Integer> sourceIds, AgentVo agentVo) {
        AgentTypeVo agentType = agentVo.getAgentType();
        // 是否接收数据
        Boolean canReceiveEvents = agentType.getCanReceiveEvents();
        // 是否接收数据源
        Boolean hasSources = agentVo.getHasSources();
        JSONObject optionsJSON = agentVo.getOptionsJSON();
        // 需要找的数据上溯多上天
        Integer expectedUpdatePeriodInDays = optionsJSON.getInteger("expected_update_period_in_days");
        //和之前多少条数据做对比
        Integer lookback = optionsJSON.getInteger("lookback");
        if (canReceiveEvents && hasSources) {
            LambdaQueryWrapper<ScheduleEvents> query = Wrappers.lambdaQuery(ScheduleEvents.class);
            query.orderByDesc(ScheduleEvents::getCreatedAt);
            query.in(ScheduleEvents::getAgentId, sourceIds);
            // 还没被别的任务处理的任务
//            query.isNull(ScheduleEvents::getLockedBy);
            if (Objects.nonNull(expectedUpdatePeriodInDays)) {
                query.ge(ScheduleEvents::getCreatedAt, LocalDateTime.now().minusDays(expectedUpdatePeriodInDays));
            }
            if (Objects.nonNull(lookback)) {
                query.last("limit " + lookback);
            }
            return eventsService.list(query);
        }
        return new ArrayList<>();
    }

}
