package cn.cxnxs.scheduler.quartz;

import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.scheduler.core.*;
import cn.cxnxs.scheduler.entity.ScheduleAgent;
import cn.cxnxs.scheduler.entity.ScheduleAgentLogs;
import cn.cxnxs.scheduler.entity.ScheduleEvents;
import cn.cxnxs.scheduler.enums.RunState;
import cn.cxnxs.scheduler.service.AgentServiceImpl;
import cn.cxnxs.scheduler.service.EventsServiceImpl;
import cn.cxnxs.scheduler.vo.AgentTypeVo;
import cn.cxnxs.scheduler.vo.AgentVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;

@Slf4j
@Component
public class JobSupport {

    @Autowired
    private AgentServiceImpl agentService;

    @Autowired
    private EventsServiceImpl eventsService;

    @Autowired
    private TaskScheduler taskScheduler;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private JobGenerator jobGenerator;

    /**
     * 保存日志信息
     *
     * @param runLogs
     * @param success
     */
    public ScheduleAgentLogs saveLogs(Integer agentId, ScheduleAgentLogs scheduleAgentLogs, RunLogs runLogs, Boolean success) {

        if (scheduleAgentLogs == null) {
            //新增
            scheduleAgentLogs = new ScheduleAgentLogs();
            scheduleAgentLogs.setAgentId(agentId);
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
     * 保存运行结果到数据库
     *
     * @param canCreateEvents 是否保存结果
     * @param payload         采集到的数据内容列表
     * @param options         任务配置信息
     * @return 数据是否有变动
     */
    public boolean saveEvents(final Integer agentId, final Integer taskId, final Boolean canCreateEvents, final JSONObject options, final JSONArray payload) {
        AtomicBoolean isChange = new AtomicBoolean(false);
        if (payload == null) {
            return isChange.get();
        }
        String mode = options.getString("mode");
        //和多少条数据对比去重
        Integer uniquenessLookBack = options.getInteger("uniqueness_look_back");

        payload.forEach(map -> {
            ScheduleEvents eventAdd = new ScheduleEvents();
            eventAdd.setAgentId(agentId);
            eventAdd.setTaskId(taskId);
            eventAdd.setPayload(JSON.toJSONString(map));
            eventAdd.setCreatedAt(LocalDateTime.now());
            //是否保存事件
            if (canCreateEvents) {
                // on_change 表示数据发生改变的时候才插入，即不产生重复数据
                if (StringUtil.isNotEmpty(mode)) {
                    if (Objects.equals(mode, "on_change")) {
                        if (!eventsService.exists(agentId, uniquenessLookBack, eventAdd.getPayload())) {
                            isChange.set(true);
                            eventAdd.insert();
                        }
                    } else {
                        isChange.set(true);
                        eventAdd.insert();
                    }
                } else {
                    if ((!eventsService.exists(agentId, uniquenessLookBack, eventAdd.getPayload()))) {
                        isChange.set(true);
                        eventAdd.insert();
                    }
                }
            }
        });
        return isChange.get();
    }

    /**
     * 成功回调
     *
     * @param agentLogs
     * @param agentType
     * @param agentVo
     * @return
     */
    public Consumer<RunResult> getSuccessCallback(ScheduleAgentLogs agentLogs, AgentTypeVo agentType, AgentVo agentVo) {
        return runResult -> {
            //成功
            log.info("执行结果：{}", runResult);
            // 保存日志
            this.saveLogs(agentVo.getId(), agentLogs, runResult.getRunLogs(), runResult.getSuccess());
            if (runResult.getSuccess()) {
                // 保存结果
                boolean isChange = this.saveEvents(agentVo.getId(), agentLogs.getId(), agentType.getCanCreateEvents(), agentVo.getOptionsJSON(), runResult.getPayload());
                //执行接收者任务
                if (isChange && (runResult.getPayload() != null && runResult.getPayload().size() > 0)) {
                    ScheduleAgent scheduleAgent = new ScheduleAgent();
                    scheduleAgent.setId(agentVo.getId());
                    scheduleAgent.setLastDataIme(LocalDateTime.now());
                    scheduleAgent.updateById();
                    // 如果运行结果没采集到数据就不立即触发下个任务了
                    try {
                        this.runNextDelayedJobs(agentVo);
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
    public Function<Throwable, Void> getExceptionallyFunction(AgentVo agentVo, ScheduleAgentLogs agentLogs) {
        return ex -> {
            //失败
            log.error("线程运行发生异常,任务执行失败", ex);
            Thread thread = Thread.currentThread();
            RunLogs runLogs = RunLogs.create(thread.getId() + "-" + thread.getName());
            runLogs.error("执行发生异常：{}", ex);
            ScheduleAgent scheduleAgent = new ScheduleAgent();
            scheduleAgent.setId(agentVo.getId());
            scheduleAgent.setLastErrorLogTime(LocalDateTime.now());
            scheduleAgent.updateById();
            // 保存日志
            this.saveLogs(agentVo.getId(), agentLogs, runLogs, false);
            return null;
        };
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
            ScheduleAgentLogs agentLogs = this.saveLogs(agentVo.getId(), null, null, null);
            // 处理多条数据
            IAgent agentInstance = jobGenerator.buildAgent(agentVo);
            ((MultipleSourcesAgent) agentInstance).setEvents(events);
            TaskRunnable taskRunnable = new TaskRunnable(agentInstance);
            CompletableFuture<RunResult> future = CompletableFuture.supplyAsync(taskRunnable, threadPoolTaskExecutor.getThreadPoolExecutor());
            future.thenAccept(getSuccessCallback(agentLogs, agentType, agentVo)).exceptionally(getExceptionallyFunction(agentLogs));
        } else if (SingleSourceAgent.class.isAssignableFrom(agentType.getHandlerClass())
                && !CollectionUtils.isEmpty(events)) {
            // 处理单条数据
            for (Event event : events) {
                Thread.sleep(500);
                // 保存日志，记录运行记录
                ScheduleAgentLogs agentLogs = this.saveLogs(getId(), null, null, null);
                IAgent agentInstance = jobGenerator.buildAgent(agentVo);
                ((SingleSourceAgent) agentInstance).setEvent(event);
                TaskRunnable taskRunnable = new TaskRunnable(agentInstance);
                CompletableFuture<RunResult> future = CompletableFuture.supplyAsync(taskRunnable, threadPoolTaskExecutor.getThreadPoolExecutor());
                future.thenAccept(getSuccessCallback(agentLogs, agentType, agentVo)).exceptionally(getExceptionallyFunction(agentLogs));
            }
        } else {
            // 保存日志，记录运行记录
            ScheduleAgentLogs agentLogs = this.saveLogs(getId(), null, null, null);
            // 无输入数据情况
            IAgent agentInstance = jobGenerator.buildAgent(agentVo);
            TaskRunnable taskRunnable = new TaskRunnable(agentInstance);
            CompletableFuture<RunResult> future = CompletableFuture.supplyAsync(taskRunnable, threadPoolTaskExecutor.getThreadPoolExecutor());
            future.thenAccept(getSuccessCallback(agentLogs, agentType, agentVo)).exceptionally(getExceptionallyFunction(agentLogs));
        }
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
        log.info("------执行下个代理------");
        for (AgentVo receiver : receivers) {
            //判断是否立即传播事件
            AgentVo receiverAgentVo = agentService.getAgentById(receiver.getId());
            AgentTypeVo agentType = receiverAgentVo.getAgentType();
            if (agentType.getCanReceiveEvents()
                    && receiverAgentVo.getPropagateImmediately()) {
                if (agentType.getCanBeScheduled()) {
                    //立即触发定时任务，否则让定时任务自己定时执行
                    TaskDetail taskDetail = new TaskDetail(receiverAgentVo.getName(), agentType.getAgentTypeName());
                    taskScheduler.triggerJob(taskDetail);
                } else {
                    // 非定时任务直接执行

                }
            }
        }
    }
}
