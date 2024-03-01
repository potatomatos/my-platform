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
import cn.cxnxs.scheduler.service.EventsServiceImpl;
import cn.cxnxs.scheduler.vo.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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

    @Autowired
    private EventsServiceImpl eventsService;

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
    public Integer saveAgent(@RequestBody AgentVo agentVo) throws SchedulerException {
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
            return eventsService.list(Wrappers.lambdaQuery(ScheduleEvents.class).in(ScheduleEvents::getAgentId, sourceIds).orderByDesc(ScheduleEvents::getCreatedAt).last(" limit 10"));
        }
        return new ArrayList<>();
    }

    /**
     * 获取采集数据
     *
     * @return 产生的数据列表
     */
    @ResponseResult
    @PostMapping("events/{id}")
    public PageResult<ScheduleEvents> getEvents(@PathVariable("id") Integer id, Integer pageNo, Integer limit) {
        Page<ScheduleEvents> page = PageHelper.startPage(pageNo, limit);
        List<ScheduleEvents> events = eventsService.list(Wrappers.lambdaQuery(ScheduleEvents.class).eq(ScheduleEvents::getAgentId, id).orderByDesc(ScheduleEvents::getCreatedAt));
        PageResult<ScheduleEvents> result = new PageResult<>(page.getTotal());
        result.setCurrent(page.getPageNum());
        result.setPageSize(page.getPageSize());
        result.setPages(page.getPages());
        result.setRows(events);
        return result;
    }

    /**
     * 删除单条数据
     *
     * @param id
     * @return
     */
    @ResponseResult
    @PostMapping("event/delete/{id}")
    public Boolean deleteEvent(@PathVariable("id") Integer id) {
        return eventsService.removeById(id);
    }

    /**
     * 运行日志
     *
     * @param pageWrapper
     * @return
     */
    @ResponseResult
    @PostMapping("logs")
    public PageResult<JSONObject> getEventLogs(@RequestBody PageWrapper<AgentLogQuery> pageWrapper) {
        return agentService.getAgentLogs(pageWrapper);
    }

    /**
     * 测试运行
     *
     * @param type     代理类型id
     * @param dryRunVO 数据源和配置
     * @return 代理数据
     * @throws ClassNotFoundException
     */
    @ResponseResult
    @RequestMapping("dryRun/{type}")
    public RunResult dryRun(@PathVariable("type") Integer type, @RequestBody DryRunVO dryRunVO) throws ClassNotFoundException {
        JSONObject optionsJson = JSON.parseObject(dryRunVO.getOptions());
        List<JSONObject> payloadJson = new ArrayList<>();
        if (StringUtil.isNotEmpty(dryRunVO.getPayloads())) {
            JSONArray jsonArray = JSONArray.parseArray(dryRunVO.getPayloads());
            for (int i = 0; i < jsonArray.size(); i++) {
                payloadJson.add(jsonArray.getJSONObject(i));
            }
        }
        return agentService.dryRun(type, optionsJson, payloadJson);
    }


    /**
     * 删除任务
     */
    @ResponseResult
    @GetMapping("delete/{id}")
    public Result<Boolean> delete(@PathVariable("id") Integer id) {
        boolean b = agentService.removeById(id);
        return Result.success("删除成功！", b);
    }

    /**
     * 启用任务
     */
    @ResponseResult
    @GetMapping("enable/{id}")
    public Result<Boolean> enable(@PathVariable("id") Integer id) {
        boolean b = agentService.enable(id);
        return Result.success("启用成功！", b);
    }

    /**
     * 关闭任务
     */
    @ResponseResult
    @GetMapping("disable/{id}")
    public Result<Boolean> disable(@PathVariable("id") Integer id) {
        boolean b = agentService.disable(id);
        return Result.success("关闭成功！", b);
    }


    /**
     * 获取流程数据
     *
     * @param id 分组id
     * @return
     */
    @ResponseResult
    @GetMapping("/graph/{id}")
    public TaskGraphVo graph(@PathVariable("id") Integer id) {
        return agentService.getGraphData(id);
    }

    @ResponseResult
    @PostMapping("/diagram/{id}")
    public Result<Boolean> saveDiagram(@PathVariable("id") Integer id, @RequestParam String diagram) {
        agentService.saveDiagram(id, diagram);
        return Result.success("保存成功！", true);
    }

    @ResponseResult
    @PostMapping("/tasks")
    public PageResult<TaskVO> selectTaskList(PageWrapper<Object> pageWrapper) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException {
        return agentService.selectTaskList(pageWrapper);
    }

    @ResponseResult
    @GetMapping("/runningTasks")
    public Integer runningTasks() {
        return agentService.selectRunningTaskCount();
    }


    @ResponseResult
    @PostMapping("/re-emit-event")
    public Result<Object> reEmitEvent(@RequestParam("agentId") Integer agentId, @RequestParam("eventId") Integer eventId) throws ClassNotFoundException, InterruptedException {
        agentService.reEmitEvent(agentId, eventId);
        return Result.success();
    }

    @ResponseResult
    @PostMapping("/re-emit-events/{agentId}")
    public Result<Object> reEmitEvents(@PathVariable("agentId") Integer agentId) throws ClassNotFoundException, InterruptedException {
        agentService.reEmitEvents(agentId);
        return Result.success();
    }
}

