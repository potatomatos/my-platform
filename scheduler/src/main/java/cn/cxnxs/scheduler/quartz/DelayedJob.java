package cn.cxnxs.scheduler.quartz;


import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.scheduler.core.Event;
import cn.cxnxs.scheduler.core.IAgent;
import cn.cxnxs.scheduler.entity.Events;
import cn.cxnxs.scheduler.service.IAgentService;
import cn.cxnxs.scheduler.service.IEventsService;
import cn.cxnxs.scheduler.vo.AgentTypeVo;
import cn.cxnxs.scheduler.vo.AgentVo;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>定时任务类</p>
 *
 * @author mengjinyuan
 * @date 2021-02-01 22:53
 **/
public class DelayedJob extends QuartzJobBean {

    @Autowired
    private IAgentService agentService;

    @Autowired
    private IEventsService eventsService;

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

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) {
        try {
            logger.info("------定时任务开始执行------");
            AgentVo agentVo = agentService.getAgentById(id);
            int pageNo = 1;
            int pageSize = 1000;

            //获取来源代理
            List<AgentVo> sourceAgents = agentVo.getSourceAgents();
            if (sourceAgents.size() == 0) {
                this.runTask(agentVo, null);
            } else {
                List<Integer> sourceAgentsIdList = sourceAgents.stream().map(AgentVo::getId).collect(Collectors.toList());
                IPage<Events> eventsPage = eventsService.page(new Page<>(pageNo, pageSize),
                        new QueryWrapper<Events>().in("agent_id", sourceAgentsIdList).isNull("locked_by"));
                List<Events> events = eventsPage.getRecords();
                while (events.size() > 0) {
                    //将事件添加到代理
                    for (Events event : events) {
                        event = event.selectById();
                        //判断该数据是否被其他线程处理
                        if (StringUtil.isEmpty(event.getLockedBy())) {
                            this.runTask(agentVo, event);
                        } else {
                            logger.info("该数据正在被线程");
                        }
                    }
                    pageNo++;
                    eventsPage = eventsService.page(new Page<>(pageNo, pageSize),
                            new QueryWrapper<Events>().eq("agent_id", id));
                    events = eventsPage.getRecords();
                }
            }
        } catch (ClassNotFoundException e) {
            logger.error("定时任务执行失败,找不到 指定的执行类", e);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 执行任务
     */
    public void runTask(AgentVo agentVo, final Events ev) throws ClassNotFoundException {
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
        ListeningExecutorService service = MoreExecutors.listeningDecorator(threadPoolTaskExecutor.getThreadPoolExecutor());
        ListenableFuture<List<Map<String, String>>> future = service.submit(taskRunnable);
        Futures.addCallback(future, new FutureCallback<List<Map<String, String>>>() {
            @SneakyThrows
            @Override
            public void onSuccess(List<Map<String, String>> maps) {
                logger.info("执行结果：{}", maps);
                List<Events> eventsList = new ArrayList<>();
                maps.forEach(map -> {
                    Events eventAdd = new Events();
                    eventAdd.setAgentId(id);
                    eventAdd.setPayload(JSON.toJSONString(map));
                    eventAdd.setCreatedAt(LocalDateTime.now());
                    //是否保存事件
                    if (agentType.getCanCreateEvents()) {
                        eventAdd.insert();
                    }
                    eventsList.add(eventAdd);
                });

                if (maps.size() > 0) {
                    runNextDelayedJobs(agentVo, eventsList);
                }
            }

            @Override
            public void onFailure(Throwable throwable) {
                logger.error("线程运行发生异常,任务执行失败", throwable);
            }
        }, threadPoolTaskExecutor);
    }

    /**
     * 执行下一个任务
     *
     * @param agentVo
     */
    public void runNextDelayedJobs(AgentVo agentVo, List<Events> events) throws SchedulerException, ClassNotFoundException {
        logger.info("------执行下个代理------");
        //查出所有下一级代理信息
        List<AgentVo> receivers = agentVo.getReceiverAgents();
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
                for (Events event : events) {
                    this.runTask(receiver, event);
                }
            }
        }
    }
}
