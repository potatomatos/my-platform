package cn.cxnxs.scheduler.controller;

import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.scheduler.entity.ScheduleAgentType;
import cn.cxnxs.scheduler.mapper.ScheduleAgentTypeMapper;
import cn.cxnxs.scheduler.vo.AgentTypeVo;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * agent定义信息 前端控制器
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-17
 */
@RestController
@RequestMapping("/agentType")
public class AgentTypeController {

    @Resource
    private ScheduleAgentTypeMapper scheduleAgentTypeMapper;

    @ResponseResult
    @RequestMapping
    public List<AgentTypeVo> getAgentTypes() {
        List<ScheduleAgentType> agentTypes = scheduleAgentTypeMapper.selectList(Wrappers.lambdaQuery());
        return ObjectUtil.copyListProperties(agentTypes, AgentTypeVo.class);
    }

    @RequestMapping("save")
    public Result<String> save(ScheduleAgentType agentType) {
        agentType.setCreatedAt(LocalDateTime.now());
        agentType.setUpdatedAt(LocalDateTime.now());
        scheduleAgentTypeMapper.insert(agentType);
        return Result.success("保存成功");
    }

    @SneakyThrows
    @ResponseResult
    @RequestMapping("detail/{id}")
    public AgentTypeVo detail(@PathVariable("id") Integer id) {
        ScheduleAgentType agentType = scheduleAgentTypeMapper.selectById(id);
        return ObjectUtil.transValues(agentType, AgentTypeVo.class);
    }


    @RequestMapping("delete/{id}")
    public Result<String> delete(@PathVariable("id") Integer id) {
        scheduleAgentTypeMapper.deleteById(id);
        return Result.success("删除成功");
    }

    @RequestMapping("modify")
    public Result<String> modify(ScheduleAgentType agentType) {
        agentType.setUpdatedAt(LocalDateTime.now());
        scheduleAgentTypeMapper.updateById(agentType);
        return Result.success("更新成功");
    }

    @ResponseResult
    @RequestMapping("schedules")
    public JSONArray schedules() {
        return AgentTypeVo.ScheduleEnum.toJson();
    }
}

