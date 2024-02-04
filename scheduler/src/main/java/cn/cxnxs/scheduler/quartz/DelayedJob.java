package cn.cxnxs.scheduler.quartz;


import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.scheduler.core.Event;
import cn.cxnxs.scheduler.core.IAgent;
import cn.cxnxs.scheduler.core.RunLogs;
import cn.cxnxs.scheduler.core.RunResult;
import cn.cxnxs.scheduler.entity.ScheduleAgent;
import cn.cxnxs.scheduler.entity.ScheduleAgentLogs;
import cn.cxnxs.scheduler.entity.ScheduleEvents;
import cn.cxnxs.scheduler.service.AgentServiceImpl;
import cn.cxnxs.scheduler.service.EventsServiceImpl;
import cn.cxnxs.scheduler.vo.AgentTypeVo;
import cn.cxnxs.scheduler.vo.AgentVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.util.concurrent.*;
import lombok.SneakyThrows;
import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.QuartzJobBean;

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
public class DelayedJob extends QuartzJobBean {

    @Autowired
    private AgentServiceImpl agentService;

    @Autowired
    private EventsServiceImpl eventsService;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private JobGenerator jobGenerator;

    @Autowired
    private TaskScheduler taskScheduler;

    private static final Logger logger = LoggerFactory.getLogger(DelayedJob.class);

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
        if (Objects.equals(agentVo.getState(), AgentVo.AgentState.DISABLE.getCode())) {
            // 任务已禁用
            return;
        }
        try {
            logger.info("------开始运行:{}------", agentVo.getName());
            //获取来源代理
            List<AgentVo> sourceAgents = agentVo.getSourceAgents();
            if (sourceAgents.size() == 0) {
                this.runTask(agentVo, null);
            } else {
                logger.info("数据来源：{}", sourceAgents.stream().map(AgentVo::getName).collect(Collectors.toList()));
                if (sourcesAreRunning(sourceAgents.stream().map(AgentVo::getId).collect(Collectors.toList()))) {
                    return;
                }
                int pageNo = 1;
                int pageSize = 1000;
                List<Integer> sourceAgentsIdList = sourceAgents.stream().map(AgentVo::getId).collect(Collectors.toList());
                IPage<ScheduleEvents> eventsPage = eventsService.page(new Page<>(pageNo, pageSize), Wrappers.lambdaQuery(ScheduleEvents.class).in(ScheduleEvents::getAgentId, sourceAgentsIdList).isNull(ScheduleEvents::getLockedBy));
                List<ScheduleEvents> events = eventsPage.getRecords();
                while (events.size() > 0) {
                    //将事件添加到代理
                    for (ScheduleEvents event : events) {
                        event = event.selectById();
                        //判断该数据是否被其他线程处理
                        if (StringUtil.isEmpty(event.getLockedBy())) {
                            this.runTask(agentVo, event);
                        } else {
                            logger.info("该数据正在被线程");
                        }
                    }
                    pageNo++;
                    eventsPage = eventsService.page(new Page<>(pageNo, pageSize), Wrappers.lambdaQuery(ScheduleEvents.class).eq(ScheduleEvents::getAgentId, id));
                    events = eventsPage.getRecords();
                }
            }
        } catch (Exception e) {
            logger.error("定时任务执行失败", e);
            // 将任务状态修改为错误
            agentService.updateAgentState(agentVo.getId(), AgentVo.AgentState.ERROR);
        }
    }

    /**
     * 执行任务
     */
    public void runTask(AgentVo agentVo, final ScheduleEvents ev) throws ClassNotFoundException {
        Thread t = Thread.currentThread();
        Event event = null;
        if (ev != null) {
            event = new Event();
            ObjectUtil.transValues(ev, Event.class);
            ev.setLockedBy(t.getName());
            ev.updateById();
        }
        AgentTypeVo agentType = agentVo.getAgentType();
        IAgent agentInstance = jobGenerator.buildAgent(agentVo);
        TaskRunnable taskRunnable = new TaskRunnable();
        taskRunnable.setAgent(agentInstance);
        taskRunnable.setEvent(event);
        // 保存日志，记录运行记录
        ScheduleAgentLogs agentLogs = saveLogs(null, event, null, null);

        // 更新状态为运行中
        agentService.updateAgentState(agentVo.getId(), AgentVo.AgentState.WORKING);

        ListeningExecutorService service = MoreExecutors.listeningDecorator(threadPoolTaskExecutor.getThreadPoolExecutor());
        ListenableFuture<RunResult> future = service.submit(taskRunnable);
        Futures.addCallback(future, new FutureCallback<RunResult>() {
            @SneakyThrows
            @Override
            public void onSuccess(RunResult runResult) {
                logger.info("执行结果：{}", runResult);
                // 保存日志
                saveLogs(agentLogs, null, runResult.getRunLogs(), runResult.getSuccess());
                if (runResult.getSuccess()) {
                    // 保存结果
                    List<ScheduleEvents> scheduleEvents = saveEvents(agentLogs.getId(), agentType.getCanCreateEvents(), agentVo.getOptionsJSON(), runResult.getPayload());
                    runNextDelayedJobs(agentVo, scheduleEvents);
                    //任务暂停，等待下次运行
                    agentService.updateAgentState(agentVo.getId(), AgentVo.AgentState.PAUSE);
                }
            }

            @Override
            public void onFailure(Throwable e) {
                logger.error("线程运行发生异常,任务执行失败", e);
                Thread thread = Thread.currentThread();
                RunLogs runLogs = RunLogs.create(thread.getId() + "-" + thread.getName());
                runLogs.error("执行发生异常：{}", e.getMessage());
                // 保存日志
                saveLogs(agentLogs, null, runLogs, false);
                // 任务错误
                agentService.updateAgentState(agentVo.getId(), AgentVo.AgentState.ERROR);
            }
        }, threadPoolTaskExecutor);
    }

    /**
     * 保存运行结果到数据库
     *
     * @param canCreateEvents 是否保存结果
     * @param payload         采集到的数据内容列表
     * @param options         任务配置信息
     * @return
     */
    public List<ScheduleEvents> saveEvents(final Integer taskId, final Boolean canCreateEvents, final JSONObject options, final JSONArray payload) {
        List<ScheduleEvents> scheduleEventsList = new ArrayList<>();
        String mode = options.getString("mode");
        payload.forEach(map -> {
            ScheduleEvents eventAdd = new ScheduleEvents();
            eventAdd.setAgentId(id);
            eventAdd.setTaskId(taskId);
            eventAdd.setPayload(JSON.toJSONString(map));
            eventAdd.setCreatedAt(LocalDateTime.now());
            //是否保存事件
            if (canCreateEvents) {
                // on_change 表示数据发生改变的时候才插入，即不产生重复数据
                if (Objects.equals(mode, "on_change")) {
                    if (!eventsService.exists(id, eventAdd.getPayload())) {
                        eventAdd.insert();
                    }
                } else {
                    eventAdd.insert();
                }
            }
            scheduleEventsList.add(eventAdd);
        });
        return scheduleEventsList;
    }

    /**
     * 保存日志信息
     *
     * @param runLogs
     * @param success
     */
    public ScheduleAgentLogs saveLogs(ScheduleAgentLogs scheduleAgentLogs, Event event, RunLogs runLogs, Boolean success) {
        if (scheduleAgentLogs == null) {
            //新增
            scheduleAgentLogs = new ScheduleAgentLogs();
            scheduleAgentLogs.setAgentId(getId());
            // 待运行
            scheduleAgentLogs.setLevel(3);
            scheduleAgentLogs.setCreatedAt(LocalDateTime.now());
            scheduleAgentLogs.setInboundEventId(event != null ? event.getId() : null);
            scheduleAgentLogs.insert();
        } else {
            // 更新
            scheduleAgentLogs.setMessage(runLogs.toString());
            // 1：成功2：失败
            scheduleAgentLogs.setLevel(success ? 1 : 2);
            scheduleAgentLogs.setUpdatedAt(LocalDateTime.now());
            scheduleAgentLogs.insertOrUpdate();
        }
        return scheduleAgentLogs;
    }

    /**
     * 执行下一个任务
     *
     * @param agentVo
     */
    public void runNextDelayedJobs(AgentVo agentVo, List<ScheduleEvents> events) throws SchedulerException, ClassNotFoundException {
        //查出所有下一级代理信息
        List<AgentVo> receivers = agentVo.getReceiverAgents();
        if (!receivers.isEmpty()) {
            logger.info("------执行下个代理------");
        }
        for (AgentVo receiver : receivers) {
            //判断是否立即传播事件
            AgentVo receiverAgentVo = agentService.getAgentById(receiver.getId());
            AgentTypeVo agentType = receiverAgentVo.getAgentType();
            //判断是不是定时任务，是：启动定时任务，否：直接执行任务
            if (agentType.getCanBeScheduled()) {
                //手动触发定时任务
                TaskDetail taskDetail = new TaskDetail();
                taskDetail.setJobName(receiverAgentVo.getName());
                taskDetail.setJobGroupName(agentType.getAgentTypeName());
                taskScheduler.triggerJob(taskDetail);
            } else {
                for (ScheduleEvents event : events) {
                    this.runTask(receiverAgentVo, event);
                }
            }
        }
    }

    /**
     * 判断数据源是否没有正在运行的，停止了数据准备好了，才可以运行
     *
     * @param sourceIds 数据源任务id
     */
    public Boolean sourcesAreRunning(List<Integer> sourceIds) {
        List<ScheduleAgent> runningAgents = agentService.list(Wrappers.lambdaQuery(ScheduleAgent.class)
                .in(ScheduleAgent::getId, sourceIds)
                .eq(ScheduleAgent::getState, AgentVo.AgentState.WORKING)
        );
        if (runningAgents.size() > 0) {
            logger.info("数据源{}正在执行中，本次任务取消", runningAgents.stream().map(ScheduleAgent::getName).collect(Collectors.toList()));
            return true;
        }
        return false;
    }
}
