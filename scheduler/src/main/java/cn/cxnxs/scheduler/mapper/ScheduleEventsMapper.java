package cn.cxnxs.scheduler.mapper;


import cn.cxnxs.scheduler.entity.ScheduleEvents;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 代理事件 Mapper 接口
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
public interface ScheduleEventsMapper extends BaseMapper<ScheduleEvents> {

    Integer getUniquenessLookBackCount(@Param("agentId") Integer agentId, @Param("uniquenessLookBack") Integer uniquenessLookBack, @Param("payloadMd5") String payloadMd5);
}
