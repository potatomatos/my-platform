package cn.cxnxs.scheduler.controller;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.PageResult;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.scheduler.core.RunResult;
import cn.cxnxs.scheduler.entity.ScheduleAgent;
import cn.cxnxs.scheduler.entity.ScheduleEvents;
import cn.cxnxs.scheduler.exception.AgentNotFoundException;
import cn.cxnxs.scheduler.service.AgentServiceImpl;
import cn.cxnxs.scheduler.vo.AgentTypeVo;
import cn.cxnxs.scheduler.vo.AgentVo;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <p>
 * 爬虫任务配置信息 前端控制器
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
@RestController
@RequestMapping("/agents")
public class AgentController {

    @Autowired
    private AgentServiceImpl agentService;

    @RequestMapping
    public Result<AgentVo> list(@RequestBody PageWrapper<AgentVo> pageWrapper) {
        return agentService.pageList(pageWrapper);
    }

    @ResponseResult
    @RequestMapping("all")
    public List<AgentVo> listAll() {
        List<ScheduleAgent> agents = agentService.list();
        return ObjectUtil.copyListProperties(agents, AgentVo.class);
    }

    @ResponseResult
    @RequestMapping("find")
    public List<AgentVo> find(@RequestBody AgentTypeVo agentTypeVo) {
        return agentService.findByTypeProperties(agentTypeVo);
    }

    @ResponseResult
    @RequestMapping("save")
    public Map<String, String> saveAgent(@RequestBody AgentVo agentVo) {
        return agentService.saveAgent(agentVo);
    }

    @ResponseResult
    @RequestMapping("{id}")
    public AgentVo getOne(@PathVariable("id") Integer id) throws AgentNotFoundException {
        return agentService.getAgentById(id);
    }

    /**
     * 获取数据源产生的数据
     *
     * @return 数据源产生的数据列表
     */
    @ResponseResult
    @GetMapping("source/events/{id}")
    public List<ScheduleEvents> getSourcesEvents(@PathVariable("id") Integer id) {
        AgentVo agent = agentService.getAgentById(id);
        if (!Objects.isNull(agent.getSourceAgents()) && !agent.getSourceAgents().isEmpty()) {
            List<Integer> sourceIds = agent.getSourceAgents().stream().map(AgentVo::getId).collect(Collectors.toList());
            return new ScheduleEvents().selectList(Wrappers.lambdaQuery(ScheduleEvents.class).in(ScheduleEvents::getAgentId, sourceIds).orderByDesc(ScheduleEvents::getCreatedAt).last(" limit 10"));
        }
        return new ArrayList<>();
    }

    /**
     * 获取采集数据
     *
     * @return 产生的数据列表
     */
    @ResponseResult
    @GetMapping("events/{id}")
    public PageResult<ScheduleEvents> getEvents(@PathVariable("id") Integer id, Integer pageNo, Integer limit) {
        Page<ScheduleEvents> page = PageHelper.startPage(pageNo, limit);
        List<ScheduleEvents> events = new ScheduleEvents().selectList(Wrappers.lambdaQuery(ScheduleEvents.class).eq(ScheduleEvents::getAgentId, id).orderByDesc(ScheduleEvents::getCreatedAt));
        PageResult<ScheduleEvents> result = new PageResult<>(page.getTotal());
        result.setCurrent(page.getPageNum());
        result.setPageSize(page.getPageSize());
        result.setPages(page.getPages());
        result.setRows(events);
        return result;
    }

    /**
     * 测试运行
     *
     * @param type     代理类型id
     * @param options  配置
     * @param payloads 数据源
     * @return 代理数据
     * @throws ClassNotFoundException
     */
    @ResponseResult
    @RequestMapping("dryRun/{type}")
    public RunResult dryRun(@PathVariable("type") Integer type,
                            @RequestParam String options,
                            String payloads) throws ClassNotFoundException {
        JSONObject optionsJson = JSON.parseObject(options);
        List<JSONObject> payloadJson = new ArrayList<>();
        if (StringUtil.isNotEmpty(payloads)) {
            JSONArray jsonArray = JSONArray.parseArray(payloads);
            for (int i = 0; i < jsonArray.size(); i++) {
                payloadJson.add(jsonArray.getJSONObject(i));
            }
        }
        return agentService.dryRun(type, optionsJson, payloadJson);
    }
}

