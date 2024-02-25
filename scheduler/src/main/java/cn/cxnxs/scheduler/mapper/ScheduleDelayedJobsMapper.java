package cn.cxnxs.scheduler.mapper;


import cn.cxnxs.scheduler.entity.ScheduleDelayedJobs;
import cn.cxnxs.scheduler.vo.TaskVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author mengjinyuan
 * @since 2021-02-02
 */
public interface ScheduleDelayedJobsMapper extends BaseMapper<ScheduleDelayedJobs> {

    @Select("select a.*,b.name as agentName from schedule_delayed_jobs a left join schedule_agent b on a.agent_id=b.id order by a.created_at desc")
    List<TaskVO> selectTaskList();
}
