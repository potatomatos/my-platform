package cn.cxnxs.scheduler.mapper;


import cn.cxnxs.scheduler.entity.ScheduleAgent;
import cn.cxnxs.scheduler.vo.AgentTypeVo;
import cn.cxnxs.scheduler.vo.AgentVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * <p>
 * 爬虫任务配置信息 Mapper 接口
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
public interface AgentMapper extends BaseMapper<ScheduleAgent> {

    List<ScheduleAgent> selectByTypeProperties(AgentTypeVo agentTypeVo);

    IPage<ScheduleAgent> pageSelectList(Page<ScheduleAgent> page, AgentVo agentVo);
}
