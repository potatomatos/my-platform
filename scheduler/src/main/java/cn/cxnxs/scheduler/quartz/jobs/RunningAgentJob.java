package cn.cxnxs.scheduler.quartz.jobs;


import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.scheduler.core.*;
import cn.cxnxs.scheduler.entity.ScheduleAgent;
import cn.cxnxs.scheduler.entity.ScheduleAgentLogs;
import cn.cxnxs.scheduler.entity.ScheduleEvents;
import cn.cxnxs.scheduler.enums.RunState;
import cn.cxnxs.scheduler.quartz.JobGenerator;
import cn.cxnxs.scheduler.quartz.TaskDetail;
import cn.cxnxs.scheduler.quartz.TaskRunnable;
import cn.cxnxs.scheduler.quartz.TaskScheduler;
import cn.cxnxs.scheduler.service.AgentServiceImpl;
import cn.cxnxs.scheduler.service.EventsServiceImpl;
import cn.cxnxs.scheduler.vo.AgentTypeVo;
import cn.cxnxs.scheduler.vo.AgentVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.quartz.JobExecutionContext;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
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
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private JobGenerator jobGenerator;

    @Autowired
    private TaskScheduler taskScheduler;

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
                this.runTask(agentVo, null);
            } else {
                // 假如不是立即传播的话，先检查数据源任务是不是都执行完成了，否则等待数据准备完成才能执行
                if (!agentVo.getPropagateImmediately()
                        && sourcesAreRunning(sourceAgents.stream().map(AgentVo::getId).collect(Collectors.toList()))) {
                    return;
                }
                List<Integer> sourceAgentsIdList = sourceAgents.stream().map(AgentVo::getId).collect(Collectors.toList());
                List<ScheduleEvents> events = getSourceEvents(sourceAgentsIdList, agentVo);
                this.runTask(agentVo, events);
            }
        } catch (Exception e) {
            logger.error("定时任务执行失败", e);
        }
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

    /**
     * <h1>执行任务</h1>
     */
    public void runTask(AgentVo agentVo, final List<ScheduleEvents> evs) throws ClassNotFoundException, InterruptedException {

        Thread t = Thread.currentThread();
        List<Event> events;
        if (!CollectionUtils.isEmpty(evs)) {
            events = new ArrayList<>();
            // 把任务锁定
            evs.forEach(item -> {
                Event event = ObjectUtil.transValues(item, Event.class);
                assert event != null;
                event.setPayload(JSONObject.parseObject(item.getPayload()));
                events.add(event);
                item.setLockedBy(t.getName());
                item.setUpdatedAt(LocalDateTime.now());
                item.updateById();
            });
        } else {
            events = null;
        }

        AgentTypeVo agentType = agentVo.getAgentType();
        if (MultipleSourcesAgent.class.isAssignableFrom(agentType.getHandlerClass())
                && !CollectionUtils.isEmpty(events)) {
            // 保存日志，记录运行记录
            ScheduleAgentLogs agentLogs = saveLogs(null, null, null);
            // 处理多条数据
            IAgent agentInstance = jobGenerator.buildAgent(agentVo);
            ((MultipleSourcesAgent) agentInstance).setEvents(events);
            TaskRunnable taskRunnable = new TaskRunnable(agentInstance);
            CompletableFuture<RunResult> future = CompletableFuture.supplyAsync(taskRunnable, threadPoolTaskExecutor.getThreadPoolExecutor());
            future.thenAccept(getResultConsumer(agentLogs, agentType, agentVo)).exceptionally(getExceptionallyFunction(agentLogs));
        } else if (SingleSourceAgent.class.isAssignableFrom(agentType.getHandlerClass())
                && !CollectionUtils.isEmpty(events)) {
            // 处理单条数据
            for (Event event : events) {
                Thread.sleep(500);
                // 保存日志，记录运行记录
                ScheduleAgentLogs agentLogs = saveLogs(null, null, null);
                IAgent agentInstance = jobGenerator.buildAgent(agentVo);
                ((SingleSourceAgent) agentInstance).setEvent(event);
                TaskRunnable taskRunnable = new TaskRunnable(agentInstance);
                CompletableFuture<RunResult> future = CompletableFuture.supplyAsync(taskRunnable, threadPoolTaskExecutor.getThreadPoolExecutor());
                future.thenAccept(getResultConsumer(agentLogs, agentType, agentVo)).exceptionally(getExceptionallyFunction(agentLogs));
            }
        } else {
            // 保存日志，记录运行记录
            ScheduleAgentLogs agentLogs = saveLogs(null, null, null);
            // 无输入数据情况
            IAgent agentInstance = jobGenerator.buildAgent(agentVo);
            TaskRunnable taskRunnable = new TaskRunnable(agentInstance);
            CompletableFuture<RunResult> future = CompletableFuture.supplyAsync(taskRunnable, threadPoolTaskExecutor.getThreadPoolExecutor());
            future.thenAccept(getResultConsumer(agentLogs, agentType, agentVo)).exceptionally(getExceptionallyFunction(agentLogs));
        }
    }

    /**
     * 成功回调
     *
     * @param agentLogs
     * @param agentType
     * @param agentVo
     * @return
     */
    public Consumer<RunResult> getResultConsumer(ScheduleAgentLogs agentLogs, AgentTypeVo agentType, AgentVo agentVo) {
        return runResult -> {
            //成功
            logger.info("执行结果：{}", runResult);
            // 保存日志
            saveLogs(agentLogs, runResult.getRunLogs(), runResult.getSuccess());
            if (runResult.getSuccess()) {
                // 保存结果
                boolean isChange = saveEvents(agentLogs.getId(), agentType.getCanCreateEvents(), agentVo.getOptionsJSON(), runResult.getPayload());
                //执行接收者任务
                if (isChange && (runResult.getPayload() != null && runResult.getPayload().size() > 0)) {
                    ScheduleAgent scheduleAgent = new ScheduleAgent();
                    scheduleAgent.setId(getId());
                    scheduleAgent.setLastDataIme(LocalDateTime.now());
                    scheduleAgent.updateById();
                    // 如果运行结果没采集到数据就不立即触发下个任务了
                    try {
                        runNextDelayedJobs(agentVo);
                    } catch (SchedulerException e) {
                        throw new RuntimeException(e);
                    }
                }
                //任务暂停，等待下次运行
                agentService.updateAgentState(agentVo.getId(), AgentVo.AgentState.PAUSE);
            }
        };
    }

    /**
     * 异常处理
     *
     * @return
     */
    public Function<Throwable, Void> getExceptionallyFunction(ScheduleAgentLogs agentLogs) {
        return ex -> {
            //失败
            logger.error("线程运行发生异常,任务执行失败", ex);
            Thread thread = Thread.currentThread();
            RunLogs runLogs = RunLogs.create(thread.getId() + "-" + thread.getName());
            runLogs.error("执行发生异常：{}", ex);
            ScheduleAgent scheduleAgent = new ScheduleAgent();
            scheduleAgent.setId(getId());
            scheduleAgent.setLastErrorLogTime(LocalDateTime.now());
            scheduleAgent.updateById();
            // 保存日志
            saveLogs(agentLogs, runLogs, false);
            return null;
        };
    }

    /**
     * 保存运行结果到数据库
     *
     * @param canCreateEvents 是否保存结果
     * @param payload         采集到的数据内容列表
     * @param options         任务配置信息
     * @return 数据是否有变动
     */
    public boolean saveEvents(final Integer taskId, final Boolean canCreateEvents, final JSONObject options, final JSONArray payload) {
        AtomicBoolean isChange = new AtomicBoolean(false);
        if (payload == null) {
            return isChange.get();
        }
        String mode = options.getString("mode");
        //和多少条数据对比去重
        Integer uniquenessLookBack = options.getInteger("uniqueness_look_back");

        payload.forEach(map -> {
            ScheduleEvents eventAdd = new ScheduleEvents();
            eventAdd.setAgentId(id);
            eventAdd.setTaskId(taskId);
            eventAdd.setPayload(JSON.toJSONString(map));
            eventAdd.setCreatedAt(LocalDateTime.now());
            //是否保存事件
            if (canCreateEvents) {
                // on_change 表示数据发生改变的时候才插入，即不产生重复数据
                if (StringUtil.isNotEmpty(mode)) {
                    if (Objects.equals(mode, "on_change")) {
                        if (!eventsService.exists(id, uniquenessLookBack, eventAdd.getPayload())) {
                            isChange.set(true);
                            eventAdd.insert();
                        }
                    } else {
                        isChange.set(true);
                        eventAdd.insert();
                    }
                } else {
                    if ((!eventsService.exists(id, uniquenessLookBack, eventAdd.getPayload()))) {
                        isChange.set(true);
                        eventAdd.insert();
                    }
                }
            }
        });
        return isChange.get();
    }

    /**
     * 保存日志信息
     *
     * @param runLogs
     * @param success
     */
    public ScheduleAgentLogs saveLogs(ScheduleAgentLogs scheduleAgentLogs, RunLogs runLogs, Boolean success) {

        if (scheduleAgentLogs == null) {
            //新增
            scheduleAgentLogs = new ScheduleAgentLogs();
            scheduleAgentLogs.setAgentId(getId());
            scheduleAgentLogs.setLevel(1);
            scheduleAgentLogs.setCreatedAt(LocalDateTime.now());
            scheduleAgentLogs.setState(RunState.WORKING.getCode());
            scheduleAgentLogs.insert();
        } else {
            // 更新
            scheduleAgentLogs.setMessage(runLogs.toString());
            scheduleAgentLogs.setUpdatedAt(LocalDateTime.now());
            scheduleAgentLogs.setState(success ? RunState.COMPLETE.getCode() : RunState.ERROR.getCode());
            scheduleAgentLogs.insertOrUpdate();
        }
        return scheduleAgentLogs;
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
     * 执行下一个任务
     *
     * @param agentVo
     */
    public void runNextDelayedJobs(AgentVo agentVo) throws SchedulerException {
        //查出所有下一级代理信息
        List<AgentVo> receivers = agentVo.getReceiverAgents();
        if (receivers.isEmpty()) {
            return;
        }
        logger.info("------执行下个代理------");
        for (AgentVo receiver : receivers) {
            //判断是否立即传播事件
            AgentVo receiverAgentVo = agentService.getAgentById(receiver.getId());
            AgentTypeVo agentType = receiverAgentVo.getAgentType();
            if (agentType.getCanReceiveEvents()
                    && receiverAgentVo.getPropagateImmediately()) {
                //立即触发定时任务，否则让定时任务自己定时执行
                TaskDetail taskDetail = new TaskDetail(receiverAgentVo.getName(), agentType.getAgentTypeName());
                taskScheduler.triggerJob(taskDetail);
            }
        }
    }
}
