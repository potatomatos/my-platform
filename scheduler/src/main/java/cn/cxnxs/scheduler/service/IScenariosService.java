package cn.cxnxs.scheduler.service;

import cn.cxnxs.scheduler.entity.ScheduleScenarios;
import cn.cxnxs.scheduler.vo.ScenariosVo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 * 任务场景 服务类
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
public interface IScenariosService extends IService<ScheduleScenarios> {

    /**
     * 分页获取场景
     *
     * @param scenariosVo 查询条件
     * @return -
     */
    IPage<ScenariosVo> getList(Page<ScenariosVo> page, ScenariosVo scenariosVo);

    /**
     * 获取详情
     *
     * @param id none
     * @return -
     */
    ScenariosVo getDetail(Integer id);

    /**
     * 保存数据
     *
     * @param scenariosVo
     * @return -
     */
    Map<String, String> saveScenarios(ScenariosVo scenariosVo);

    /**
     * 删除方案
     *
     * @param type 删除类型
     * @param id   id
     * @return none
     */
    Map<String, String> deleteScenarios(String type, String id);
}
