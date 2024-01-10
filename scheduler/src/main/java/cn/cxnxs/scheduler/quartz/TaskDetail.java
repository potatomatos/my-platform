package cn.cxnxs.scheduler.quartz;

import org.quartz.Job;
import org.quartz.JobDataMap;

/**
 * <p>定时任务信息</p>
 *
 * @author mengjinyuan
 * @date 2021-02-03 01:19
 **/
public class TaskDetail {

    private String jobName;

    private String jobGroupName;

    private String triggerName;

    private String triggerGroupName;

    private Class<? extends Job> jobClass;

    private String cron;

    private JobDataMap jobDataMap = new JobDataMap();

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public void setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroupName() {
        return triggerGroupName;
    }

    public void setTriggerGroupName(String triggerGroupName) {
        this.triggerGroupName = triggerGroupName;
    }

    public Class<? extends Job> getJobClass() {
        return jobClass;
    }

    public void setJobClass(Class<? extends Job> jobClass) {
        this.jobClass = jobClass;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public JobDataMap getJobDataMap() {
        return jobDataMap;
    }

    public void setJobDataMap(JobDataMap jobDataMap) {
        if (jobDataMap == null || jobDataMap.isEmpty()) {
            return;
        }
        this.jobDataMap = jobDataMap;
    }

    @Override
    public String toString() {
        return "TaskDetail{" +
                "jobName='" + jobName + '\'' +
                ", jobGroupName='" + jobGroupName + '\'' +
                ", triggerName='" + triggerName + '\'' +
                ", triggerGroupName='" + triggerGroupName + '\'' +
                ", jobClass=" + jobClass +
                ", cron='" + cron + '\'' +
                ", jobDataMap=" + jobDataMap +
                '}';
    }
}
