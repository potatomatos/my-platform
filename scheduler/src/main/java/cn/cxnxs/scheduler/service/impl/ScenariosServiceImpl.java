package cn.cxnxs.scheduler.service.impl;

import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.scheduler.entity.Agent;
import cn.cxnxs.scheduler.entity.ScenarioAgentRel;
import cn.cxnxs.scheduler.entity.Scenarios;
import cn.cxnxs.scheduler.exception.BusinessException;
import cn.cxnxs.scheduler.mapper.ScenariosMapper;
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
public class ScenariosServiceImpl extends ServiceImpl<ScenariosMapper, Scenarios> implements IScenariosService {

    @Autowired
    private ScenariosMapper scenariosMapper;

    @Autowired
    private IScenarioAgentRelService scenarioAgentRelService;

    @Autowired
    private IAgentService agentService;

    private static final String TYPE_ONLY_SCEN = "1";
    private static final String TYPE_SCEN_AGENT = "2";

    @Override
    public IPage<ScenariosVo> getList(Page<ScenariosVo> page, ScenariosVo scenariosVo) {
        return scenariosMapper.selectScenariosList(page, scenariosVo);
    }

    /**
     * 获取详情
     *
     * @param id none
     * @return
     */
    @Override
    public ScenariosVo getDetail(Integer id) {
        Scenarios scenarios = super.getById(id);
        ScenariosVo scenariosVo = new ScenariosVo();
        if (scenarios != null) {
            BeanUtils.copyProperties(scenarios, scenariosVo);
            List<ScenarioAgentRel> scenarioAgentRels = scenarioAgentRelService
                    .list(new QueryWrapper<ScenarioAgentRel>().eq("scenario_id", id));
            if (scenarioAgentRels.size() != 0) {
                List<Agent> allAgents = agentService.list();
                List<AgentVo> agentVos = ObjectUtil.copyListProperties(allAgents, AgentVo.class);
                for (AgentVo agentVo : agentVos) {
                    for (ScenarioAgentRel scenarioAgentRel : scenarioAgentRels) {
                        if (scenarioAgentRel.getAgentId().equals(agentVo.getId())) {
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
        Scenarios scenarios = new Scenarios();
        BeanUtils.copyProperties(scenariosVo, scenarios);
        super.saveOrUpdate(scenarios);
        //保存关系
        if (scenariosVo.getAgentIds() != null) {
            if (scenariosVo.getId() != null) {
                scenarioAgentRelService.remove(new QueryWrapper<ScenarioAgentRel>().eq("scenario_id", scenariosVo.getId()));
            }
            List<ScenarioAgentRel> scenarioAgentRels = new ArrayList<>();
            for (Integer agentId : scenariosVo.getAgentIds()) {
                ScenarioAgentRel scenarioAgentRel = new ScenarioAgentRel();
                scenarioAgentRel.setAgentId(agentId);
                scenarioAgentRel.setScenarioId(scenarios.getId());
                scenarioAgentRel.setCreatedAt(LocalDateTime.now());
                scenarioAgentRels.add(scenarioAgentRel);
            }
            scenarioAgentRelService.saveBatch(scenarioAgentRels);
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
            List<ScenarioAgentRel> scenarioAgentRels = scenarioAgentRelService.list(new QueryWrapper<ScenarioAgentRel>().eq("scenario_id", id));
            if (scenarioAgentRels.size() != 0) {
                List<Integer> ids = new ArrayList<>();
                scenarioAgentRels.forEach(s -> {
                    ids.add(s.getAgentId());
                });
                //删除代理
                agentService.removeByIds(ids);
                //删除方案和代理关系
                scenarioAgentRelService.remove(new QueryWrapper<ScenarioAgentRel>().in("agent_id", ids));
            }
        } else {
            throw new BusinessException("删除类型不正确");
        }
        return new HashMap<>(0);
    }
}
