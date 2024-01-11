package cn.cxnxs.scheduler.service.impl;

import cn.cxnxs.scheduler.entity.ScheduleEvents;
import cn.cxnxs.scheduler.mapper.ScheduleEventsMapper;
import cn.cxnxs.scheduler.service.IEventsService;
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
public class EventsServiceImpl extends ServiceImpl<ScheduleEventsMapper, ScheduleEvents> implements IEventsService {

}
