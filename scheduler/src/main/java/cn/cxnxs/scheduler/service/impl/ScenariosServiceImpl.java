package cn.cxnxs.scheduler.service.impl;

import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.scheduler.entity.ScheduleAgent;
import cn.cxnxs.scheduler.entity.ScheduleScenarioAgentRel;
import cn.cxnxs.scheduler.entity.ScheduleScenarios;
import cn.cxnxs.scheduler.exception.BusinessException;
import cn.cxnxs.scheduler.mapper.ScheduleScenariosMapper;
import cn.cxnxs.scheduler.service.IAgentService;
import cn.cxnxs.scheduler.service.IScenarioAgentRelService;
import cn.cxnxs.scheduler.service.IScenariosService;
import cn.cxnxs.scheduler.vo.AgentVo;
import cn.cxnxs.scheduler.vo.ScenariosVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 任务场景 服务实现类
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
@Service
public class ScenariosServiceImpl extends ServiceImpl<ScheduleScenariosMapper, ScheduleScenarios> implements IScenariosService {

    @Autowired
    private ScheduleScenariosMapper scheduleScenariosMapper;

    @Autowired
    private IScenarioAgentRelService scenarioAgentRelService;

    @Autowired
    private IAgentService agentService;

    private static final String TYPE_ONLY_SCEN = "1";
    private static final String TYPE_SCEN_AGENT = "2";

    @Override
    public IPage<ScenariosVo> getList(Page<ScenariosVo> page, ScenariosVo scenariosVo) {
        return scheduleScenariosMapper.selectScenariosList(page, scenariosVo);
    }

    /**
     * 获取详情
     *
     * @param id none
     * @return
     */
    @Override
    public ScenariosVo getDetail(Integer id) {
        ScheduleScenarios scheduleScenarios = super.getById(id);
        ScenariosVo scenariosVo = new ScenariosVo();
        if (scheduleScenarios != null) {
            BeanUtils.copyProperties(scheduleScenarios, scenariosVo);
            List<ScheduleScenarioAgentRel> scheduleScenarioAgentRels = scenarioAgentRelService
                    .list(new QueryWrapper<ScheduleScenarioAgentRel>().eq("scenario_id", id));
            if (scheduleScenarioAgentRels.size() != 0) {
                List<ScheduleAgent> allScheduleAgents = agentService.list();
                List<AgentVo> agentVos = ObjectUtil.copyListProperties(allScheduleAgents, AgentVo.class);
                for (AgentVo agentVo : agentVos) {
                    for (ScheduleScenarioAgentRel scheduleScenarioAgentRel : scheduleScenarioAgentRels) {
                        if (scheduleScenarioAgentRel.getAgentId().equals(agentVo.getId())) {
                            agentVo.setSelected(true);
                            break;
                        }
                    }
                }
                scenariosVo.setAgents(agentVos);
            }
        }
        return scenariosVo;
    }

    /**
     * 保存数据
     *
     * @param scenariosVo
     * @return none
     */
    @Transactional
    @Override
    public Map<String, String> saveScenarios(ScenariosVo scenariosVo) {
        ScheduleScenarios scheduleScenarios = new ScheduleScenarios();
        BeanUtils.copyProperties(scenariosVo, scheduleScenarios);
        super.saveOrUpdate(scheduleScenarios);
        //保存关系
        if (scenariosVo.getAgentIds() != null) {
            if (scenariosVo.getId() != null) {
                scenarioAgentRelService.remove(new QueryWrapper<ScheduleScenarioAgentRel>().eq("scenario_id", scenariosVo.getId()));
            }
            List<ScheduleScenarioAgentRel> scheduleScenarioAgentRels = new ArrayList<>();
            for (Integer agentId : scenariosVo.getAgentIds()) {
                ScheduleScenarioAgentRel scheduleScenarioAgentRel = new ScheduleScenarioAgentRel();
                scheduleScenarioAgentRel.setAgentId(agentId);
                scheduleScenarioAgentRel.setScenarioId(scheduleScenarios.getId());
                scheduleScenarioAgentRel.setCreatedAt(LocalDateTime.now());
                scheduleScenarioAgentRels.add(scheduleScenarioAgentRel);
            }
            scenarioAgentRelService.saveBatch(scheduleScenarioAgentRels);
        }
        return new HashMap<>(0);
    }

    /**
     * 删除方案
     *
     * @param type 删除类型 1：只删除方案。2：删除方案以及关联的代理
     * @param id   id
     * @return none
     */
    @Transactional
    @Override
    public Map<String, String> deleteScenarios(String type, String id) {
        if (TYPE_ONLY_SCEN.equals(type)) {
            //删除方案
            super.removeById(id);
            //删除方案和代理关系
            Map<String, Object> condition = new HashMap<>(1);
            condition.put("scenario_id", id);
            scenarioAgentRelService.removeByMap(condition);
        } else if (TYPE_SCEN_AGENT.equals(type)) {
            //删除方案
            super.removeById(id);
            List<ScheduleScenarioAgentRel> scheduleScenarioAgentRels = scenarioAgentRelService.list(new QueryWrapper<ScheduleScenarioAgentRel>().eq("scenario_id", id));
            if (scheduleScenarioAgentRels.size() != 0) {
                List<Integer> ids = new ArrayList<>();
                scheduleScenarioAgentRels.forEach(s -> {
                    ids.add(s.getAgentId());
                });
                //删除代理
                agentService.removeByIds(ids);
                //删除方案和代理关系
                scenarioAgentRelService.remove(new QueryWrapper<ScheduleScenarioAgentRel>().in("agent_id", ids));
            }
        } else {
            throw new BusinessException("删除类型不正确");
        }
        return new HashMap<>(0);
    }
}
