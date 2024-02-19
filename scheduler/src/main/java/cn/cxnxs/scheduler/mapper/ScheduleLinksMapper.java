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

    @Select("select a.id, a.name, a.type, b.agent_type_name as typeName\n" +
            "     , count(e.agent_id) as eventCount\n" +
            "from schedule_agent a\n" +
            "         left join schedule_agent_type b on a.type = b.id\n" +
            "         left join schedule_events e on a.id = e.agent_id\n" +
            "where a.id in (\n" +
            "    select agent_id\n" +
            "    from schedule_scenario_agent_rel where scenario_id = #{id}\n" +
            ")\n" +
            "group by a.id, a.name, a.type, b.agent_type_name")
    List<GraphNode> selectGraphNodes(Integer id);

    @Select("select id, source_id as startId, receiver_id as endId\n" +
            "from schedule_links\n" +
            "where source_id in (\n" +
            "    select agent_id\n" +
            "    from schedule_scenario_agent_rel\n" +
            "    where scenario_id = #{id}\n" +
            ")\n" +
            "   or receiver_id in (select agent_id from schedule_scenario_agent_rel where scenario_id = #{id})")
    List<GraphLink> selectGraphLinks(Integer id);
}
