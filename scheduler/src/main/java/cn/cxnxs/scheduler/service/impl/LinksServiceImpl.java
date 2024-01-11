package cn.cxnxs.scheduler.service.impl;

import cn.cxnxs.scheduler.entity.ScheduleLinks;
import cn.cxnxs.scheduler.mapper.ScheduleLinksMapper;
import cn.cxnxs.scheduler.service.ILinksService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * agent关联 服务实现类
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
@Service
public class LinksServiceImpl extends ServiceImpl<ScheduleLinksMapper, ScheduleLinks> implements ILinksService {

}
