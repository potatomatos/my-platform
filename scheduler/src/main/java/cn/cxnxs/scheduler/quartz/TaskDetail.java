package cn.cxnxs.scheduler.quartz;

import lombok.Getter;
import lombok.Setter;
import org.quartz.Job;
import org.quartz.JobDataMap;

/**
 * <p>定时任务信息</p>
 *
 * @author mengjinyuan
 * @date 2021-02-03 01:19
 **/
@Getter
@Setter
public class TaskDetail {

    private String jobName;

    private String jobGroupName;

    private String triggerName;

    private String triggerGroupName;

    private Class<? extends Job> jobClass;

    private String cron;

    private JobDataMap jobDataMap = new JobDataMap();
}