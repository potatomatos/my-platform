package cn.cxnxs.scheduler.quartz;

import cn.cxnxs.scheduler.exception.ScheduleException;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;


/**
 * @author potatomato
 */
@Slf4j
@Component
public class TaskScheduler {

    @Autowired
    SchedulerFactoryBean schedulerFactory;

    /**
     * 添加一个定时任务
     *
     * @param taskDetail 任务信息
     */
    public void addJob(TaskDetail taskDetail) {
        log.info("------添加定时任务：{}", taskDetail);
        try {
            if (checkExists(taskDetail)) {
                return;
            }
            Scheduler scheduler = schedulerFactory.getScheduler();
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
            log.error("添加任务出现异常！", e);
            throw new ScheduleException("添加任务出现异常!");
        }
    }

    /**
     * 添加一个手动任务
     *
     * @param taskDetail
     */
    public void addManualJob(TaskDetail taskDetail) {
        log.info("------添加定时任务：{}", taskDetail);
        try {
            if (checkExists(taskDetail)) {
                return;
            }
            Scheduler scheduler = schedulerFactory.getScheduler();
            JobDetail jobDetail = JobBuilder
                    .newJob(taskDetail.getJobClass())
                    .withIdentity(taskDetail.getJobName(), taskDetail.getJobGroupName())
                    .setJobData(taskDetail.getJobDataMap())
                    .build();
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(taskDetail.getTriggerName(), taskDetail.getTriggerGroupName())
                    .startAt(DateBuilder.futureDate(10, DateBuilder.IntervalUnit.YEAR)) // 设置一个未来很长的时间
                    .build();
            scheduler.scheduleJob(jobDetail, trigger);
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (SchedulerException e) {
            log.error("添加手动任务出现异常！", e);
            throw new ScheduleException("添加手动任务出现异常!");
        }
    }

    /**
     * 修改一个任务的触发时间
     *
     * @param taskDetail 任务信息
     */
    public void modifyJobTime(TaskDetail taskDetail) {
        log.info("修改一个任务的触发时间：{}", taskDetail);
        try {
            log.info("------修改定时任务，{}", taskDetail);
            Scheduler scheduler = schedulerFactory.getScheduler();
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
            log.error("修改任务出现异常！", e);
        }
    }

    /**
     * 移除一个任务
     *
     * @param taskDetail 任务信息
     */
    public void removeJob(TaskDetail taskDetail) {
        log.info("移除一个任务：{}", taskDetail);
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(taskDetail.getTriggerName(), taskDetail.getTriggerGroupName());
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(JobKey.jobKey(taskDetail.getJobName(), taskDetail.getJobGroupName()));
        } catch (Exception e) {
            log.error("移除任务出现异常！", e);
        }
    }


    /**
     * 暂停一个任务
     *
     * @param taskDetail 任务信息
     */
    public void pauseJob(TaskDetail taskDetail) {
        log.info("暂停一个任务：{}", taskDetail);
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(taskDetail.getTriggerName(), taskDetail.getTriggerGroupName());
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.pauseTrigger(triggerKey);
            scheduler.pauseJob(JobKey.jobKey(taskDetail.getJobName(), taskDetail.getJobGroupName()));
        } catch (SchedulerException e) {
            log.error("暂停任务出现异常！", e);
        }
    }

    /**
     * 恢复一个job
     *
     * @param taskDetail 任务信息
     * @throws SchedulerException
     */
    public void resumeJob(TaskDetail taskDetail) throws SchedulerException {
        log.info("恢复一个job：{}", taskDetail);
        TriggerKey triggerKey = TriggerKey.triggerKey(taskDetail.getTriggerName(), taskDetail.getTriggerGroupName());
        Scheduler scheduler = schedulerFactory.getScheduler();
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
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobKey jobKey = JobKey.jobKey(taskDetail.getJobName(), taskDetail.getJobGroupName());
        if (checkExists(taskDetail)) {
            log.info("手动触发一个job：{}", taskDetail);
            scheduler.triggerJob(jobKey);
        }
    }

    public Boolean checkExists(TaskDetail taskDetail) throws SchedulerException {
        return schedulerFactory.getScheduler().checkExists(JobKey.jobKey(taskDetail.getJobName(), taskDetail.getJobGroupName()));
    }

    /**
     * 启动所有定时任务
     */
    public void startJobs() {
        log.info("启动所有定时任务");
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.start();
        } catch (Exception e) {
            log.error("启动所有任务出现异常！", e);
        }
    }

    /**
     * 关闭所有定时任务
     */
    public void shutdownJobs() {
        log.info("关闭所有定时任务");
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            if (!scheduler.isShutdown()) {
                scheduler.shutdown();
            }
        } catch (Exception e) {
            log.error("关闭所有定时任务出现异常！", e);
        }
    }
}
