package cn.cxnxs.scheduler.quartz.jobs;

import cn.cxnxs.scheduler.core.IAgent;
import cn.cxnxs.scheduler.core.RunResult;
import cn.cxnxs.scheduler.entity.ScheduleDelayedJobs;
import cn.cxnxs.scheduler.mapper.ScheduleDelayedJobsMapper;
import cn.cxnxs.scheduler.quartz.TaskRunnable;
import cn.cxnxs.scheduler.utils.SerializeUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 扫描队列中的任务并处理
 */
@Slf4j
public class DelayedJobsProcessJob extends QuartzJobBean {

    @Resource
    private ScheduleDelayedJobsMapper scheduleDelayedJobsMapper;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        log.info("======开始处理任务队列======");
        // 一次处理100条数据
        List<ScheduleDelayedJobs> delayedJobs = scheduleDelayedJobsMapper.selectList(Wrappers.lambdaQuery(ScheduleDelayedJobs.class).isNotNull(ScheduleDelayedJobs::getHandler).orderByAsc(ScheduleDelayedJobs::getCreatedAt).last(" limit 100"));
        for (ScheduleDelayedJobs delayedJob : delayedJobs) {
            IAgent agent = SerializeUtil.deserializeObjectFromString(delayedJob.getHandler());
            TaskRunnable taskRunnable = new TaskRunnable(agent);
            CompletableFuture<RunResult> future = CompletableFuture.supplyAsync(taskRunnable, threadPoolTaskExecutor.getThreadPoolExecutor());
            future.thenAccept(runResult -> {
            }).exceptionally(ex -> null);
        }

    }


}
