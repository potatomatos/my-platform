package cn.cxnxs.scheduler.quartz;

import cn.cxnxs.scheduler.core.IAgent;
import cn.cxnxs.scheduler.entity.ScheduleDelayedJobs;
import cn.cxnxs.scheduler.mapper.ScheduleDelayedJobsMapper;
import cn.cxnxs.scheduler.utils.SerializeUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义拒绝策略
 */
@Slf4j
@Component
public class RejectedExecutionHandler4DelayedJobs implements RejectedExecutionHandler {

    @Resource
    private ScheduleDelayedJobsMapper scheduleDelayedJobsMapper;

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            Field taskField = Class.forName("java.util.concurrent.CompletableFuture$AsyncSupply").getDeclaredField("fn");
            taskField.setAccessible(true); // 设置私有字段可以访问
            Object task = taskField.get(r);
            log.info("任务{}被拒绝，状态如下：\n{}", task, getExecutorStatus(executor));

            // 检查task是否是TaskRunnable的实例
            if (task instanceof TaskRunnable) {
                TaskRunnable taskRunnable = (TaskRunnable) task;
                IAgent agent = taskRunnable.getAgent();
                // 序列化存储到数据库
                if (Objects.nonNull(agent)) {
                    String serializeObjectToString = SerializeUtil.serializeObjectToString(agent);
                    if (Objects.nonNull(serializeObjectToString)) {
                        Integer count = scheduleDelayedJobsMapper.selectCount(Wrappers.lambdaQuery(ScheduleDelayedJobs.class).eq(ScheduleDelayedJobs::getHandler, serializeObjectToString));
                        if (count == 0) {
                            ScheduleDelayedJobs scheduleDelayedJobs = new ScheduleDelayedJobs();
                            scheduleDelayedJobs.setAgentId(agent.getId());
                            scheduleDelayedJobs.setPriority(1);
                            scheduleDelayedJobs.setHandler(serializeObjectToString);
                            scheduleDelayedJobs.setThreadId(Thread.currentThread().getName());
                            scheduleDelayedJobs.setCreatedAt(LocalDateTime.now());
                            scheduleDelayedJobsMapper.insert(scheduleDelayedJobs);
                        }
                    }
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException | ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 获取线程池运行状态
     *
     * @param executor
     * @return
     */
    public JSONObject getExecutorStatus(ThreadPoolExecutor executor) {
        JSONObject jsonObject = new JSONObject();
        // 获取线程池的一些状态信息
        int poolSize = executor.getPoolSize(); // 当前线程池中的线程数
        int activeCount = executor.getActiveCount(); // 线程池中当前执行任务的线程数
        long completedTaskCount = executor.getCompletedTaskCount(); // 线程池已完成的任务数
        int largestPoolSize = executor.getLargestPoolSize(); // 线程池曾经创建过的最大线程数
        long taskCount = executor.getTaskCount(); // 线程池需要执行的任务总数
        int queueSize = executor.getQueue().size(); // 任务队列中当前的任务数

        // 使用这些信息
        jsonObject.put("当前线程池大小", poolSize);
        jsonObject.put("活跃线程数", activeCount);
        jsonObject.put("已完成任务数", completedTaskCount);
        jsonObject.put("历史最大线程数", largestPoolSize);
        jsonObject.put("任务总数", taskCount);
        jsonObject.put("队列中的任务数", queueSize);
        return jsonObject;
    }

}
