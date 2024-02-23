package cn.cxnxs.scheduler.quartz.jobs;

import cn.cxnxs.scheduler.entity.ScheduleAgent;
import cn.cxnxs.scheduler.entity.ScheduleEvents;
import cn.cxnxs.scheduler.service.AgentServiceImpl;
import cn.cxnxs.scheduler.service.EventsServiceImpl;
import cn.cxnxs.scheduler.vo.AgentTypeVo;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * 删除过期数据定时任务
 */
@Slf4j
public class ExpiredDataDeletionJob extends QuartzJobBean {

    @Autowired
    private AgentServiceImpl agentService;

    @Autowired
    private EventsServiceImpl eventsService;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        log.info("======开始删除过期数据======");
        List<ScheduleAgent> agents = agentService.list();
        for (ScheduleAgent agent : agents) {
            Integer keepDataTime = agent.getKeepDataTime();
            AgentTypeVo.KeepEventsTime keepEventsTime = AgentTypeVo.KeepEventsTime.getValue(keepDataTime);
            if (Objects.nonNull(keepEventsTime)
                    && !Objects.equals(keepEventsTime, AgentTypeVo.KeepEventsTime.FOREVER)
                    && !Objects.equals(keepEventsTime, AgentTypeVo.KeepEventsTime.ONE_YEAR)) {
                eventsService.remove(Wrappers.lambdaQuery(ScheduleEvents.class)
                        .eq(ScheduleEvents::getAgentId, agent.getId()).lt(ScheduleEvents::getCreatedAt, LocalDateTime.now().minusHours(keepEventsTime.getHours()))
                );
            } else if (Objects.equals(keepEventsTime, AgentTypeVo.KeepEventsTime.ONE_YEAR)) {
                eventsService.remove(Wrappers.lambdaQuery(ScheduleEvents.class)
                        .eq(ScheduleEvents::getAgentId, agent.getId()).lt(ScheduleEvents::getCreatedAt, LocalDateTime.now().minusYears(1)));
            }
            // 更新数据数量
            agent.setDataCount(eventsService.count(Wrappers.lambdaQuery(ScheduleEvents.class).eq(ScheduleEvents::getAgentId, agent.getId())));
            agent.updateById();
        }
    }
}
