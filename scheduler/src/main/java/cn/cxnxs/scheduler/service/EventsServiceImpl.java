package cn.cxnxs.scheduler.service;

import cn.cxnxs.scheduler.entity.ScheduleEvents;
import cn.cxnxs.scheduler.mapper.ScheduleEventsMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 代理事件 服务实现类
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
@Service
public class EventsServiceImpl extends ServiceImpl<ScheduleEventsMapper, ScheduleEvents> {

    /**
     * 判断内容是否存在
     *
     * @param agentId
     * @param payload
     * @return
     */
    public Boolean exists(Integer agentId, Integer uniquenessLookBack, String payload) {
        return baseMapper.getUniquenessLookBackCount(agentId, uniquenessLookBack, payload) > 0;
    }
}
