package cn.cxnxs.scheduler.service;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.PageResult;
import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.scheduler.core.*;
import cn.cxnxs.scheduler.entity.*;
import cn.cxnxs.scheduler.exception.AgentNotFoundException;
import cn.cxnxs.scheduler.mapper.ScheduleAgentMapper;
import cn.cxnxs.scheduler.utils.SpringContextUtil;
import cn.cxnxs.scheduler.vo.AgentTypeVo;
import cn.cxnxs.scheduler.vo.AgentVo;
import cn.cxnxs.scheduler.vo.ScenariosVo;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 爬虫任务配置信息 服务实现类
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
@Service
public class AgentServiceImpl extends ServiceImpl<ScheduleAgentMapper, ScheduleAgent> {


    @Autowired
    private ScenarioAgentRelServiceImpl scenarioAgentRelService;

    @Autowired
    private LinksServiceImpl linksService;


    public List<AgentVo> findByTypeProperties(AgentTypeVo agentTypeVo) {
        ScheduleAgentMapper scheduleAgentMapper = getBaseMapper();
        List<ScheduleAgent> scheduleAgents = scheduleAgentMapper.selectByTypeProperties(agentTypeVo);
        return ObjectUtil.copyListProperties(scheduleAgents, AgentVo.class);
    }

    @Transactional

    public Map<String, String> saveAgent(AgentVo agentVo) {
        //保存代理
        ScheduleAgent scheduleAgent = new ScheduleAgent();
        ObjectUtil.transValues(agentVo, scheduleAgent);
        scheduleAgent.insertOrUpdate();
        //保存代理和方案关系
        scenarioAgentRelService.remove(Wrappers.lambdaQuery(ScheduleScenarioAgentRel.class).eq(ScheduleScenarioAgentRel::getAgentId, scheduleAgent.getId()));
        if (StringUtil.isNotEmpty(agentVo.getScenarioIds())) {
            String[] scenarios = agentVo.getScenarioIds().split(",");
            for (String scenarioId : scenarios) {
                ScheduleScenarioAgentRel senarioAgentRel = new ScheduleScenarioAgentRel();
                senarioAgentRel.setAgentId(scheduleAgent.getId());
                senarioAgentRel.setScenarioId(Integer.parseInt(scenarioId));
                senarioAgentRel.setCreatedAt(LocalDateTime.now());
                senarioAgentRel.insertOrUpdate();
            }
        }
        //保存代理-代理关系
        linksService.remove(Wrappers.lambdaQuery(ScheduleLinks.class).eq(ScheduleLinks::getSourceId, scheduleAgent.getId()));
        if (StringUtil.isNotEmpty(agentVo.getReceiverIds())) {
            String[] receivers = agentVo.getReceiverIds().split(",");
            for (String receiverId : receivers) {
                ScheduleLinks scheduleLinks = new ScheduleLinks();
                scheduleLinks.setSourceId(scheduleAgent.getId());
                scheduleLinks.setReceiverId(Integer.parseInt(receiverId));
                scheduleLinks.setCreatedAt(LocalDateTime.now());
                scheduleLinks.insertOrUpdate();
            }
        }
        linksService.remove(Wrappers.lambdaQuery(ScheduleLinks.class).eq(ScheduleLinks::getReceiverId, scheduleAgent.getId()));
        if (StringUtil.isNotEmpty(agentVo.getSourceIds())) {
            String[] sources = agentVo.getSourceIds().split(",");
            for (String sourceId : sources) {
                ScheduleLinks scheduleLinks = new ScheduleLinks();
                scheduleLinks.setSourceId(Integer.parseInt(sourceId));
                scheduleLinks.setReceiverId(scheduleAgent.getId());
                scheduleLinks.setCreatedAt(LocalDateTime.now());
                scheduleLinks.insertOrUpdate();
            }
        }

        return new HashMap<>();
    }


    public AgentVo getAgentById(Integer id) throws AgentNotFoundException {
        if (id == null) {
            throw new AgentNotFoundException();
        }
        //获取代理信息
        ScheduleAgent scheduleAgent = getById(id);
        if (scheduleAgent == null) {
            throw new AgentNotFoundException();
        }
        AgentVo agentVo = new AgentVo();
        ObjectUtil.transValues(scheduleAgent, agentVo);
        //获取数据源
        List<ScheduleLinks> sourcesLinks = new ScheduleLinks().selectList(Wrappers.lambdaQuery(ScheduleLinks.class).eq(ScheduleLinks::getReceiverId, id));
        if (sourcesLinks.size() != 0) {
            List<Integer> sourcesIds = new ArrayList<>();
            for (ScheduleLinks scheduleLinks : sourcesLinks) {
                sourcesIds.add(scheduleLinks.getSourceId());
            }
            List<ScheduleAgent> sources = new ScheduleAgent().selectList(Wrappers.lambdaQuery(ScheduleAgent.class).in(ScheduleAgent::getId, sourcesIds));
            agentVo.setSourceAgents(ObjectUtil.copyListProperties(sources, AgentVo.class));
        }
        //获取接收者
        List<ScheduleLinks> receiversLinks = new ScheduleLinks().selectList(Wrappers.lambdaQuery(ScheduleLinks.class).eq(ScheduleLinks::getSourceId, id));
        if (receiversLinks.size() != 0) {
            List<Integer> receiversIds = new ArrayList<>();
            for (ScheduleLinks scheduleLinks : receiversLinks) {
                receiversIds.add(scheduleLinks.getReceiverId());
            }
            List<ScheduleAgent> receivers = new ScheduleAgent().selectList(Wrappers.lambdaQuery(ScheduleAgent.class).in(ScheduleAgent::getId, receiversIds));
            agentVo.setReceiverAgents(ObjectUtil.copyListProperties(receivers, AgentVo.class));
        }
        //获取方案
        List<ScheduleScenarioAgentRel> scheduleScenarioAgentRels = new ScheduleScenarioAgentRel().selectList(Wrappers.lambdaQuery(ScheduleScenarioAgentRel.class).eq(ScheduleScenarioAgentRel::getAgentId, id));
        if (scheduleScenarioAgentRels.size() != 0) {
            List<Integer> scenarioIds = new ArrayList<>();
            for (ScheduleScenarioAgentRel scheduleScenarioAgentRel : scheduleScenarioAgentRels) {
                scenarioIds.add(scheduleScenarioAgentRel.getScenarioId());
            }
            List<ScheduleScenarios> scenarios = new ScheduleScenarios().selectList(Wrappers.lambdaQuery(ScheduleScenarios.class).in(ScheduleScenarios::getId, scenarioIds));
            agentVo.setScenarios(ObjectUtil.copyListProperties(scenarios, ScenariosVo.class));
        }
        if (agentVo.getType() != null) {
            ScheduleAgentType scheduleAgentType = new ScheduleAgentType().selectById(agentVo.getType());
            AgentTypeVo agentTypeVo = new AgentTypeVo();
            ObjectUtil.transValues(scheduleAgentType, agentTypeVo);
            agentVo.setAgentType(agentTypeVo);
        }
        return agentVo;
    }


    public PageResult<AgentVo> pageList(PageWrapper<AgentVo> param) {
        AgentVo agentVo = param.getParam();
        if (StringUtil.isNotEmpty(agentVo.getName())) {
            agentVo.setName(StringUtil.sqlLike(agentVo.getName()));
        }
        PageResult<AgentVo> result = new PageResult<>(param.getPage(), param.getLimit());
        Page<ScheduleAgent> page = PageHelper.startPage(param.getPage(), param.getLimit());
        List<ScheduleAgent> list = getBaseMapper().pageSelectList(agentVo);
        List<AgentVo> agentVos = ObjectUtil.copyListProperties(list, AgentVo.class);
        agentVos.forEach(agent -> {
            //获取方案
            List<ScheduleScenarioAgentRel> scheduleScenarioAgentRels = new ScheduleScenarioAgentRel().selectList(Wrappers.lambdaQuery(ScheduleScenarioAgentRel.class).eq(ScheduleScenarioAgentRel::getAgentId, agent.getId()));
            if (scheduleScenarioAgentRels.size() != 0) {
                List<Integer> scenarioIds = new ArrayList<>();
                for (ScheduleScenarioAgentRel scheduleScenarioAgentRel : scheduleScenarioAgentRels) {
                    scenarioIds.add(scheduleScenarioAgentRel.getScenarioId());
                }
                List<ScheduleScenarios> scenarios = new ScheduleScenarios().selectList(Wrappers.lambdaQuery(ScheduleScenarios.class).in(ScheduleScenarios::getId, scenarioIds));
                agent.setScenarios(ObjectUtil.copyListProperties(scenarios, ScenariosVo.class));
            }
            //获取类型
            if (agent.getType() != null) {
                ScheduleAgentType scheduleAgentType = new ScheduleAgentType().selectById(agent.getType());
                AgentTypeVo agentTypeVo = new AgentTypeVo();
                ObjectUtil.transValues(scheduleAgentType, agentTypeVo);
                agent.setAgentType(agentTypeVo);
            }
            //是否有数据源
            Integer hasSources = new ScheduleLinks().selectCount(Wrappers.lambdaQuery(ScheduleLinks.class).eq(ScheduleLinks::getReceiverId, agent.getId()));
            Integer hasReceiver = new ScheduleLinks().selectCount(Wrappers.lambdaQuery(ScheduleLinks.class).eq(ScheduleLinks::getSourceId, agent.getId()));
            agent.setHasSources(hasSources != 0);
            agent.setHasReceivers(hasReceiver != 0);
        });
        result.setRows(agentVos);
        result.setCount(page.getTotal());
        return result;
    }


    public RunResult dryRun(Integer type, JSONObject options, List<JSONObject> payloads) throws AgentNotFoundException, ClassNotFoundException {
        ScheduleAgentType scheduleAgentType = new ScheduleAgentType().selectById(type);
        if (scheduleAgentType == null) {
            throw new AgentNotFoundException("代理类型不存在");
        }
        AgentTypeVo agentTypeVo = ObjectUtil.transValues(scheduleAgentType, AgentTypeVo.class);
        assert agentTypeVo != null;
        IAgent agent = SpringContextUtil.getBean(agentTypeVo.getHandlerClass());
        agent.setName("调试任务");
        agent.option(options);
        if (SingleSourceAgent.class.isAssignableFrom(agentTypeVo.getHandlerClass())) {
            if (!CollectionUtils.isEmpty(payloads)) {
                // 单个任务只能接收一个入参
                if (payloads.size() != 1) {
                    Thread currentThread = Thread.currentThread();
                    RunLogs runLogs = RunLogs.create(currentThread.getId() + "-" + currentThread.getName());
                    RunResult runResult = new RunResult(new JSONArray(), runLogs);
                    runResult.error("该任务只能接收一条数据！");
                    return runResult;
                }
                Event event = new Event();
                event.setPayload(payloads.get(0));
                ((SingleSourceAgent) agent).setEvent(event);
            }
        }
        if (MultipleSourcesAgent.class.isAssignableFrom(agentTypeVo.getHandlerClass())) {
            if (!CollectionUtils.isEmpty(payloads)) {
                ((MultipleSourcesAgent) agent).setEvents(payloads.stream().map(payload -> {
                    Event event = new Event();
                    event.setPayload(payload);
                    return event;
                }).collect(Collectors.toList()));
            }
        }
        return agent.runAgent();
    }

    /**
     * 更新任务状态
     *
     * @param id         任务id
     * @param agentState 状态枚举
     */
    public void updateAgentState(Integer id, AgentVo.AgentState agentState) {
        ScheduleAgent agent = new ScheduleAgent();
        agent.setId(id);
        agent.setState(agentState.getCode());
        super.updateById(agent);
    }

}
