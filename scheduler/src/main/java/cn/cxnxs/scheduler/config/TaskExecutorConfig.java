package cn.cxnxs.scheduler.config;

import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.scheduler.entity.ScheduleAgent;
import cn.cxnxs.scheduler.entity.ScheduleAgentType;
import cn.cxnxs.scheduler.quartz.CustomThreadPoolExecutor;
import cn.cxnxs.scheduler.quartz.RejectedExecutionHandler4DelayedJobs;
import cn.cxnxs.scheduler.quartz.TaskDetail;
import cn.cxnxs.scheduler.quartz.TaskScheduler;
import cn.cxnxs.scheduler.quartz.jobs.DelayedJobsProcessJob;
import cn.cxnxs.scheduler.quartz.jobs.ExpiredDataDeletionJob;
import cn.cxnxs.scheduler.quartz.jobs.RunningAgentJob;
import cn.cxnxs.scheduler.service.AgentServiceImpl;
import cn.cxnxs.scheduler.vo.AgentTypeVo;
import cn.cxnxs.scheduler.vo.AgentVo;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.quartz.JobDataMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * <p>定时任务配置</p>
 *
 * @author mengjinyuan
 * @date 2021-02-03 10:15
 **/
@Configuration
public class TaskExecutorConfig {

    /**
     * 配置核心线程数
     */
    private static final int CORE_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;
    /**
     * 配置最大线程数
     */
    private static final int MAX_POOL_SIZE = CORE_POOL_SIZE * 2;
    /**
     * 配置队列大小
     */
    private static final int QUEUE_CAPACITY = 100;

    @Autowired
    private TaskScheduler taskScheduler;

    @Autowired
    private AgentServiceImpl agentService;

    /**
     * 定义线程池
     *
     * @return none
     */
    @Bean("threadPoolTaskExecutor")
    public CustomThreadPoolExecutor CustomThreadPoolExecutor(RejectedExecutionHandler4DelayedJobs rejectedExecutionHandler4DelayedJobs) {
        return new CustomThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(QUEUE_CAPACITY), rejectedExecutionHandler4DelayedJobs);
    }

    /**
     * 初始化定时任务
     */
    @PostConstruct
    public void initScheduler() {
        //从数据库获取代理信息
        List<ScheduleAgent> scheduleAgents = agentService.list(Wrappers.lambdaQuery(ScheduleAgent.class).ne(ScheduleAgent::getState, AgentVo.AgentState.DISABLE.getCode()));
        for (ScheduleAgent scheduleAgentItem : scheduleAgents) {
            //获取类型
            ScheduleAgentType scheduleAgentType = new ScheduleAgentType().selectById(scheduleAgentItem.getType());
            String cron = AgentTypeVo.ScheduleEnum.getCron(scheduleAgentItem.getSchedule());
            TaskDetail taskDetail = new TaskDetail();
            taskDetail.setJobName(scheduleAgentItem.getName());
            taskDetail.setJobGroupName(scheduleAgentType.getAgentTypeName());
            taskDetail.setTriggerName(scheduleAgentItem.getName());
            taskDetail.setTriggerGroupName(scheduleAgentType.getAgentTypeName());
            taskDetail.setJobClass(RunningAgentJob.class);
            taskDetail.setCron(cron);
            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("id", scheduleAgentItem.getId());
            taskDetail.setJobDataMap(jobDataMap);

            //自动定时执行
            if (scheduleAgentType.getCanBeScheduled()
                    && StringUtil.isNotEmpty(cron)) {
                taskScheduler.addJob(taskDetail);
            }
        }

        // 删除过期数据-每5分钟执行一次
        initSystemScheduler(AgentTypeVo.ScheduleEnum.EVERY_5M, ExpiredDataDeletionJob.class);
        // 扫描处理队列数据-每1分钟执行一次
        initSystemScheduler(AgentTypeVo.ScheduleEnum.EVERY_1M, DelayedJobsProcessJob.class);
    }

    /**
     * 初始化
     */
    public void initSystemScheduler(AgentTypeVo.ScheduleEnum cron, Class<? extends QuartzJobBean> jobClass) {
        TaskDetail taskDetail = new TaskDetail();
        taskDetail.setJobName(jobClass.getName().replaceAll("\\.", "_"));
        taskDetail.setJobGroupName("SYSTEM_TASK");
        taskDetail.setTriggerName(jobClass.getName().replaceAll("\\.", "_"));
        taskDetail.setTriggerGroupName("SYSTEM_TASK");
        taskDetail.setJobClass(jobClass);
        taskDetail.setCron(cron.getCron());
        taskScheduler.addJob(taskDetail);
    }

}
