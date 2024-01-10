package cn.cxnxs.scheduler.quartz;

import cn.cxnxs.scheduler.exception.ScheduleException;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;


/**
 * @author potatomato
 */
@Component
public class TaskScheduler {

    private static Logger logger = LoggerFactory.getLogger(TaskScheduler.class);

    @Autowired
    SchedulerFactoryBean schedulerFactory;

    @Autowired
    private Scheduler scheduler;

    /**
     * 添加一个定时任务
     *
     * @param taskDetail 任务信息
     */
    public void addJob(TaskDetail taskDetail) {
        logger.info("------添加定时任务：{}", taskDetail);
        try {
            scheduler = schedulerFactory.getScheduler();
            JobDetail jobDetail = JobBuilder
                    .newJob(taskDetail.getJobClass())
                    .withIdentity(taskDetail.getJobName(), taskDetail.getJobGroupName())
                    .setJobData(taskDetail.getJobDataMap())
                    .build();
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            triggerBuilder.withIdentity(taskDetail.getTriggerName(), taskDetail.getTriggerGroupName());
            triggerBuilder.startNow();
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(taskDetail.getCron()));
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();
            scheduler.scheduleJob(jobDetail, trigger);
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            logger.error("添加任务出现异常！", e);
            throw new ScheduleException("添加任务出现异常!");
        }
    }

    /**
     * 修改一个任务的触发时间
     *
     * @param taskDetail 任务信息
     */
    public void modifyJobTime(TaskDetail taskDetail) {
        logger.info("修改一个任务的触发时间：{}", taskDetail);
        try {
            logger.info("------修改定时任务，{}", taskDetail);
            scheduler = schedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(taskDetail.getTriggerName(), taskDetail.getTriggerGroupName());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(taskDetail.getCron())) {
                //方式一 ：调用 rescheduleJob 开始
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                triggerBuilder.withIdentity(taskDetail.getTriggerName(), taskDetail.getTriggerGroupName());
                triggerBuilder.startNow();
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(taskDetail.getCron()));
                trigger = (CronTrigger) triggerBuilder.build();
                // 方式一 ：修改一个任务的触发时间
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        } catch (Exception e) {
            logger.error("修改任务出现异常！", e);
        }
    }

    /**
     * 移除一个任务
     *
     * @param taskDetail 任务信息
     */
    public void removeJob(TaskDetail taskDetail) {
        logger.info("移除一个任务：{}", taskDetail);
        try {
            scheduler = schedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(taskDetail.getTriggerName(), taskDetail.getTriggerGroupName());
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(JobKey.jobKey(taskDetail.getJobName(), taskDetail.getJobGroupName()));
        } catch (Exception e) {
            logger.error("移除任务出现异常！", e);
        }
    }


    /**
     * 暂停一个任务
     *
     * @param taskDetail 任务信息
     */
    public void pauseJob(TaskDetail taskDetail) {
        logger.info("暂停一个任务：{}", taskDetail);
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(taskDetail.getTriggerName(), taskDetail.getTriggerGroupName());
            scheduler = schedulerFactory.getScheduler();
            scheduler.pauseTrigger(triggerKey);
            scheduler.pauseJob(JobKey.jobKey(taskDetail.getJobName(), taskDetail.getJobGroupName()));
        } catch (SchedulerException e) {
            logger.error("暂停任务出现异常！", e);
        }
    }

    /**
     * 恢复一个job
     *
     * @param taskDetail 任务信息
     * @throws SchedulerException
     */
    public void resumeJob(TaskDetail taskDetail) throws SchedulerException {
        logger.info("恢复一个job：{}", taskDetail);
        TriggerKey triggerKey = TriggerKey.triggerKey(taskDetail.getTriggerName(), taskDetail.getTriggerGroupName());
        scheduler = schedulerFactory.getScheduler();
        scheduler.resumeTrigger(triggerKey);
        scheduler.resumeJob(JobKey.jobKey(taskDetail.getJobName(), taskDetail.getJobGroupName()));

    }

    /**
     * 手动触发一个job
     *
     * @param taskDetail 任务信息
     * @throws SchedulerException
     */
    public void triggerJob(TaskDetail taskDetail) throws SchedulerException {
        logger.info("手动触发一个job：{}", taskDetail);
        scheduler = schedulerFactory.getScheduler();
        scheduler.triggerJob(JobKey.jobKey(taskDetail.getJobName(), taskDetail.getJobGroupName()));
    }

    /**
     * 启动所有定时任务
     */
    public void startJobs() {
        logger.info("启动所有定时任务");
        try {
            scheduler = schedulerFactory.getScheduler();
            scheduler.start();
        } catch (Exception e) {
            logger.error("启动所有任务出现异常！", e);
        }
    }

    /**
     * 关闭所有定时任务
     */
    public void shutdownJobs() {
        logger.info("关闭所有定时任务");
        try {
            scheduler = schedulerFactory.getScheduler();
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        } catch (Exception e) {
            logger.error("关闭所有定时任务出现异常！", e);
        }
    }
}
