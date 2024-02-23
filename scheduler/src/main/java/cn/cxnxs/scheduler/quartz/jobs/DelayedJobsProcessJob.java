package cn.cxnxs.scheduler.quartz.jobs;

import cn.cxnxs.scheduler.core.IAgent;
import cn.cxnxs.scheduler.core.RunLogs;
import cn.cxnxs.scheduler.core.RunResult;
import cn.cxnxs.scheduler.entity.ScheduleAgent;
import cn.cxnxs.scheduler.entity.ScheduleAgentLogs;
import cn.cxnxs.scheduler.entity.ScheduleDelayedJobs;
import cn.cxnxs.scheduler.mapper.ScheduleDelayedJobsMapper;
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
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
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
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private JobSupport jobSupport;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        log.info("======开始处理任务队列======");
        // 一次处理100条数据
        List<ScheduleDelayedJobs> delayedJobs = scheduleDelayedJobsMapper.selectList(Wrappers.lambdaQuery(ScheduleDelayedJobs.class).isNotNull(ScheduleDelayedJobs::getHandler).orderByAsc(ScheduleDelayedJobs::getCreatedAt).last(" limit 100"));
        for (ScheduleDelayedJobs delayedJob : delayedJobs) {
            IAgent agent = SerializeUtil.deserializeObjectFromString(delayedJob.getHandler());
            if (Objects.isNull(agent)) {
                delayedJob.deleteById();
                continue;
            }
            AgentVo agentVo = agentService.getAgentById(agent.getId());
            AgentTypeVo agentType = agentVo.getAgentType();
            TaskRunnable taskRunnable = new TaskRunnable(agent);
            CompletableFuture<RunResult> future = CompletableFuture.supplyAsync(taskRunnable, threadPoolTaskExecutor.getThreadPoolExecutor());
            // 保存日志，记录运行记录
            ScheduleAgentLogs agentLogs = jobSupport.saveLogs(agent.getId(), null, null, null);
            future.thenAccept(runResult -> {
                // 保存日志
                jobSupport.saveLogs(agentVo.getId(), agentLogs, runResult.getRunLogs(), runResult.getSuccess());
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
                }
            }).exceptionally(ex -> {
                //失败
                Thread thread = Thread.currentThread();
                RunLogs runLogs = RunLogs.create(thread.getId() + "-" + thread.getName());
                runLogs.error("执行发生异常：{}", ex);
                ScheduleAgent scheduleAgent = new ScheduleAgent();
                scheduleAgent.setId(agentVo.getId());
                scheduleAgent.setLastErrorLogTime(LocalDateTime.now());
                scheduleAgent.updateById();
                // 保存日志
                jobSupport.saveLogs(agentVo.getId(), agentLogs, runLogs, false);

                // 记录任务状态
                delayedJob.setFailedAt(LocalDateTime.now());
                delayedJob.setLastError(ex.getMessage());
                delayedJob.setThreadId(thread.getId() + "-" + thread.getName());
                delayedJob.setAttempts(delayedJob.getAttempts() + 1);
                delayedJob.setUpdatedAt(LocalDateTime.now());
                delayedJob.updateById();
                return null;
            });
        }

    }


}
