package cn.cxnxs.scheduler.quartz.jobs;

import cn.cxnxs.scheduler.core.IAgent;
import cn.cxnxs.scheduler.core.RunLogs;
import cn.cxnxs.scheduler.core.RunResult;
import cn.cxnxs.scheduler.entity.ScheduleAgent;
import cn.cxnxs.scheduler.entity.ScheduleAgentLogs;
import cn.cxnxs.scheduler.entity.ScheduleDelayedJobs;
import cn.cxnxs.scheduler.mapper.ScheduleDelayedJobsMapper;
import cn.cxnxs.scheduler.quartz.CustomThreadPoolExecutor;
import cn.cxnxs.scheduler.quartz.JobSupport;
import cn.cxnxs.scheduler.quartz.TaskRunnable;
import cn.cxnxs.scheduler.service.AgentServiceImpl;
import cn.cxnxs.scheduler.utils.SerializeUtil;
import cn.cxnxs.scheduler.vo.AgentTypeVo;
import cn.cxnxs.scheduler.vo.AgentVo;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * 扫描队列中的任务并处理
 */
@Slf4j
public class DelayedJobsProcessJob extends QuartzJobBean {

    @Autowired
    private AgentServiceImpl agentService;

    @Resource
    private ScheduleDelayedJobsMapper scheduleDelayedJobsMapper;

    @Autowired
    private CustomThreadPoolExecutor threadPoolTaskExecutor;

    @Autowired
    private JobSupport jobSupport;

    /**
     * 最多执行5次
     */
    private static final Integer MAX_RUN_TIMES = 5;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        // 一次处理100条数据
        List<ScheduleDelayedJobs> delayedJobs = scheduleDelayedJobsMapper.selectList(Wrappers.lambdaQuery(ScheduleDelayedJobs.class).isNotNull(ScheduleDelayedJobs::getHandler).orderByAsc(ScheduleDelayedJobs::getCreatedAt).last(" limit 100"));
        if (delayedJobs.size() == 0) {
            return;
        }
        log.info("======开始处理任务队列======");
        for (ScheduleDelayedJobs delayedJob : delayedJobs) {
            IAgent agent = SerializeUtil.deserializeObjectFromString(delayedJob.getHandler());
            if (Objects.isNull(agent)) {
                delayedJob.deleteById();
                continue;
            }
            AgentVo agentVo = agentService.getAgentById(agent.getId());
            AgentTypeVo agentType = agentVo.getAgentType();
            TaskRunnable taskRunnable = new TaskRunnable(agent);
            CompletableFuture<RunResult> future = CompletableFuture.supplyAsync(taskRunnable, threadPoolTaskExecutor);
            // 保存日志，记录运行记录
            ScheduleAgentLogs agentLogs = jobSupport.saveLogs(agent.getId(), null, null, null);
            future.thenAccept(runResult -> {

                if (runResult.getSuccess()) {
                    // 删掉队列
                    delayedJob.deleteById();
                    // 保存结果
                    JSONObject saveResult = jobSupport.saveEvents(agentVo.getId(), agentLogs.getId(), agentType.getCanCreateEvents(), agentVo.getOptionsJSON(), runResult.getPayload());
                    //执行接收者任务
                    if (saveResult.getBooleanValue("isChange") && (runResult.getPayload() != null && runResult.getPayload().size() > 0)) {
                        ScheduleAgent scheduleAgent = new ScheduleAgent();
                        scheduleAgent.setId(agent.getId());
                        scheduleAgent.setLastDataIme(LocalDateTime.now());
                        scheduleAgent.updateById();
                    }
                } else {
                    if (delayedJob.getAttempts() >= MAX_RUN_TIMES) {
                        // 超过执行次数，直接删除
                        delayedJob.deleteById();
                    } else {
                        // 记录任务状态
                        delayedJob.setRunAt(LocalDateTime.now());
                        delayedJob.setFailedAt(LocalDateTime.now());
                        delayedJob.setThreadId(Thread.currentThread().getId() + "-" + Thread.currentThread().getName());
                        delayedJob.setAttempts(delayedJob.getAttempts() + 1);
                        delayedJob.setUpdatedAt(LocalDateTime.now());
                        // 放到队尾去
                        delayedJob.setCreatedAt(LocalDateTime.now());
                        delayedJob.updateById();
                    }
                }
                // 保存日志
                jobSupport.saveLogs(agentVo.getId(), agentLogs, runResult.getRunLogs(), runResult.getSuccess());
            }).exceptionally(ex -> {
                //失败
                RunLogs runLogs = RunLogs.create(Thread.currentThread().getId() + "-" + Thread.currentThread().getName());
                runLogs.error("执行发生异常：{}", ex);
                ScheduleAgent scheduleAgent = new ScheduleAgent();
                scheduleAgent.setId(agentVo.getId());
                scheduleAgent.setLastErrorLogTime(LocalDateTime.now());
                scheduleAgent.updateById();
                if (delayedJob.getAttempts() >= MAX_RUN_TIMES) {
                    // 超过执行次数，直接删除
                    delayedJob.deleteById();
                } else {
                    // 记录任务状态
                    delayedJob.setRunAt(LocalDateTime.now());
                    delayedJob.setFailedAt(LocalDateTime.now());
                    delayedJob.setLastError(ex.getMessage());
                    delayedJob.setThreadId(Thread.currentThread().getId() + "-" + Thread.currentThread().getName());
                    delayedJob.setAttempts(delayedJob.getAttempts() + 1);
                    // 放到队尾去
                    delayedJob.setCreatedAt(LocalDateTime.now());
                    delayedJob.setUpdatedAt(LocalDateTime.now());
                    delayedJob.updateById();
                }
                // 保存日志
                jobSupport.saveLogs(agentVo.getId(), agentLogs, runLogs, false);
                return null;
            });
        }

    }


}
