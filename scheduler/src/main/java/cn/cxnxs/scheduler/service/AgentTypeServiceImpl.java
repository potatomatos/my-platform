package cn.cxnxs.scheduler.service;

import cn.cxnxs.scheduler.entity.ScheduleAgentType;
import cn.cxnxs.scheduler.mapper.ScheduleAgentTypeMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * <p>
 * 爬虫任务配置信息 服务实现类
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
@Service
public class AgentTypeServiceImpl extends ServiceImpl<ScheduleAgentTypeMapper, ScheduleAgentType> {

    public Integer updateOrSave(ScheduleAgentType agentType) {
        if (!Objects.isNull(agentType.getId())) {
            agentType.setUpdatedAt(LocalDateTime.now());
            updateById(agentType);
            return agentType.getId();
        } else {
            agentType.setCreatedAt(LocalDateTime.now());
            save(agentType);
            return agentType.getId();
        }
    }
}
