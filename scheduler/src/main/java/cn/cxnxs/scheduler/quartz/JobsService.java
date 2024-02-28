package cn.cxnxs.scheduler.quartz;

import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.scheduler.core.*;
import cn.cxnxs.scheduler.entity.ScheduleAgent;
import cn.cxnxs.scheduler.entity.ScheduleAgentLogs;
import cn.cxnxs.scheduler.entity.ScheduleEvents;
import cn.cxnxs.scheduler.service.AgentServiceImpl;
import cn.cxnxs.scheduler.vo.AgentTypeVo;
import cn.cxnxs.scheduler.vo.AgentVo;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

@Service
@Slf4j
public class JobsService {

    @Autowired
    private AgentServiceImpl agentService;

    @Autowired
    private JobSupport jobSupport;

    @Autowired
    private CustomThreadPoolExecutor threadPoolTaskExecutor;

    @Autowired
    private JobGenerator jobGenerator;

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
            ScheduleAgentLogs agentLogs = jobSupport.saveLogs(agentVo.getId(), null, null, null);
            // 处理多条数据
            IAgent agentInstance = jobGenerator.buildAgent(agentVo);
            ((MultipleSourcesAgent) agentInstance).setEvents(events);
            TaskRunnable taskRunnable = new TaskRunnable(agentInstance);
            CompletableFuture<RunResult> future = CompletableFuture.supplyAsync(taskRunnable, threadPoolTaskExecutor);
            future.thenAccept(this.getSuccessCallback(agentInstance, agentLogs, agentType, agentVo)).exceptionally(this.getExceptionallyFunction(agentInstance, agentVo, agentLogs));
        } else if (SingleSourceAgent.class.isAssignableFrom(agentType.getHandlerClass())
                && !CollectionUtils.isEmpty(events)) {
            // 处理单条数据
            for (Event event : events) {
                Thread.sleep(500);
                // 保存日志，记录运行记录
                ScheduleAgentLogs agentLogs = jobSupport.saveLogs(agentVo.getId(), null, null, null);
                IAgent agentInstance = jobGenerator.buildAgent(agentVo);
                ((SingleSourceAgent) agentInstance).setEvent(event);
                TaskRunnable taskRunnable = new TaskRunnable(agentInstance);
                CompletableFuture<RunResult> future = CompletableFuture.supplyAsync(taskRunnable, threadPoolTaskExecutor);
                future.thenAccept(this.getSuccessCallback(agentInstance, agentLogs, agentType, agentVo)).exceptionally(this.getExceptionallyFunction(agentInstance, agentVo, agentLogs));
            }
        } else {
            // 保存日志，记录运行记录
            ScheduleAgentLogs agentLogs = jobSupport.saveLogs(agentVo.getId(), null, null, null);
            // 无输入数据情况
            IAgent agentInstance = jobGenerator.buildAgent(agentVo);
            TaskRunnable taskRunnable = new TaskRunnable(agentInstance);
            CompletableFuture<RunResult> future = CompletableFuture.supplyAsync(taskRunnable, threadPoolTaskExecutor);
            future.thenAccept(this.getSuccessCallback(agentInstance, agentLogs, agentType, agentVo)).exceptionally(this.getExceptionallyFunction(agentInstance, agentVo, agentLogs));
        }
    }

    /**
     * 执行下一个任务
     *
     * @param agentVo
     */
    public void runNextDelayedJobs(AgentVo agentVo, List<ScheduleEvents> evs) throws ClassNotFoundException, InterruptedException {
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
                this.runTask(receiverAgentVo, evs);
            }
        }
    }

    /**
     * 成功回调
     *
     * @param agent
     * @param agentLogs
     * @param agentType
     * @param agentVo
     * @return
     */
    public Consumer<RunResult> getSuccessCallback(IAgent agent, ScheduleAgentLogs agentLogs, AgentTypeVo agentType, AgentVo agentVo) {
        return runResult -> {
            //成功
            log.info("执行结果：{}", runResult);
            // 保存日志
            jobSupport.saveLogs(agentVo.getId(), agentLogs, runResult.getRunLogs(), runResult.getSuccess());
            if (runResult.getSuccess()) {
                // 保存结果
                JSONObject saveResult = jobSupport.saveEvents(agentVo.getId(), agentLogs.getId(), agentType.getCanCreateEvents(), agentVo.getOptionsJSON(), runResult.getPayload());
                //执行接收者任务
                if (saveResult.getBooleanValue("isChange") && (runResult.getPayload() != null && runResult.getPayload().size() > 0)) {
                    ScheduleAgent scheduleAgent = new ScheduleAgent();
                    scheduleAgent.setId(agentVo.getId());
                    scheduleAgent.setLastDataIme(LocalDateTime.now());
                    scheduleAgent.updateById();
                    // 如果运行结果没采集到数据就不立即触发下个任务了
                    try {
                        this.runNextDelayedJobs(agentVo, saveResult.getObject("row", List.class));
                    } catch (ClassNotFoundException | InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                //任务暂停，等待下次运行
                agentService.updateAgentState(agentVo.getId(), AgentVo.AgentState.PAUSE);
            } else {
                // 运行不成功，把任务放到队列里重试
                jobSupport.saveDelayedJob(agent);
            }
        };
    }

    /**
     * 异常处理
     *
     * @return
     */
    public Function<Throwable, Void> getExceptionallyFunction(IAgent agent, AgentVo agentVo, ScheduleAgentLogs agentLogs) {
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
            // 保存到队列
            jobSupport.saveDelayedJob(agent);
            // 保存日志
            jobSupport.saveLogs(agentVo.getId(), agentLogs, runLogs, false);
            return null;
        };
    }
}
