package cn.cxnxs.scheduler.mapper;

import cn.cxnxs.scheduler.entity.ScheduleScenarios;
import cn.cxnxs.scheduler.vo.ScenariosVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 任务场景 Mapper 接口
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
public interface ScheduleScenariosMapper extends BaseMapper<ScheduleScenarios> {

    List<ScenariosVo> selectScenariosList(ScenariosVo scenariosVo);
}
