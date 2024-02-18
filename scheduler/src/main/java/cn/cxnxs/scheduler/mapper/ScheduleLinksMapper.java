package cn.cxnxs.scheduler.mapper;


import cn.cxnxs.scheduler.entity.ScheduleLinks;
import cn.cxnxs.scheduler.vo.GraphLink;
import cn.cxnxs.scheduler.vo.GraphNode;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * agent关联 Mapper 接口
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
public interface ScheduleLinksMapper extends BaseMapper<ScheduleLinks> {

    @Select("SELECT a.id,\n" +
            "       a.name,\n" +
            "       a.type,\n" +
            "       b.agent_type_name AS typeName,\n" +
            "       COUNT(e.agent_id) AS eventCount\n" +
            "FROM schedule_agent a\n" +
            "         LEFT JOIN schedule_agent_type b ON a.type = b.id\n" +
            "         LEFT JOIN schedule_events e ON a.id = e.agent_id\n" +
            "WHERE a.id IN (SELECT source_id FROM schedule_links)\n" +
            "   OR a.id IN (SELECT receiver_id FROM schedule_links)\n" +
            "GROUP BY a.id, a.name, a.type, b.agent_type_name")
    List<GraphNode> selectGraphNodes();

    @Select("select id,source_id as startId,receiver_id as endId from schedule_links")
    List<GraphLink> selectGraphLinks();
}
