package cn.cxnxs.scheduler.controller;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.PageResult;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.scheduler.entity.ScheduleAgentType;
import cn.cxnxs.scheduler.service.AgentTypeServiceImpl;
import cn.cxnxs.scheduler.vo.AgentTypeVo;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
    private AgentTypeServiceImpl agentTypeService;

    @ResponseResult
    @RequestMapping
    public PageResult<AgentTypeVo> getAgentTypes(@RequestBody PageWrapper<AgentTypeVo> pageWrapper) {
        AgentTypeVo param = pageWrapper.getParam();
        LambdaQueryWrapper<ScheduleAgentType> queryWrapper = Wrappers.lambdaQuery(ScheduleAgentType.class);
        if (StringUtil.isNotEmpty(param.getKeyword())) {
            queryWrapper.like(ScheduleAgentType::getAgentTypeName, param.getKeyword())
                    .or()
                    .like(ScheduleAgentType::getHandler, param.getKeyword())
            ;
        }
        Page<Object> page = PageHelper.startPage(pageWrapper.getPage(), pageWrapper.getLimit());
        List<ScheduleAgentType> agentTypes = agentTypeService.list(queryWrapper);
        PageResult<AgentTypeVo> pageResult = new PageResult<>(page.getPageNum(), page.getPageSize(), page.getTotal());
        pageResult.setRows(ObjectUtil.copyListProperties(agentTypes, AgentTypeVo.class));
        return pageResult;
    }

    @RequestMapping("save")
    public Result<Integer> save(@RequestBody ScheduleAgentType agentType) {
        return Result.success("保存成功", agentTypeService.updateOrSave(agentType));
    }

    @SneakyThrows
    @ResponseResult
    @RequestMapping("detail/{id}")
    public AgentTypeVo detail(@PathVariable("id") Integer id) {
        ScheduleAgentType agentType = agentTypeService.getById(id);
        return ObjectUtil.transValues(agentType, AgentTypeVo.class);
    }


    @RequestMapping("delete/{id}")
    public Result<String> delete(@PathVariable("id") Integer id) {
        agentTypeService.removeById(id);
        return Result.success("删除成功");
    }

    @ResponseResult
    @RequestMapping("schedules")
    public JSONArray schedules() {
        return AgentTypeVo.ScheduleEnum.toJson();
    }
}

