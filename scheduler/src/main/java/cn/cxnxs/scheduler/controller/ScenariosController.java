package cn.cxnxs.scheduler.controller;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.PageResult;
import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.scheduler.entity.ScheduleScenarios;
import cn.cxnxs.scheduler.service.ScenariosServiceImpl;
import cn.cxnxs.scheduler.vo.ScenariosVo;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 任务场景 前端控制器
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
@RestController
@RequestMapping("/scenarios")
public class ScenariosController {

    @Autowired
    private ScenariosServiceImpl scenariosService;

    @RequestMapping
    public PageResult<ScenariosVo> list(PageWrapper<ScenariosVo> param) {
        PageResult<ScenariosVo> res = new PageResult<>(param.getPage(), param.getLimit());
        PageHelper.startPage(param.getPage(), param.getLimit());
        List<ScheduleScenarios> list = scenariosService.list(Wrappers.lambdaQuery(ScheduleScenarios.class).setEntity(ObjectUtil.transValues(param.getParam(), ScheduleScenarios.class)));
        res.setCount(res.getCount());
        res.setPages(res.getPages());
        res.setRows(ObjectUtil.copyListProperties(list, ScenariosVo.class));
        return res;
    }

    @ResponseResult
    @RequestMapping("detail/{id}")
    public ScenariosVo detail(@PathVariable("id") Integer id) {
        return scenariosService.getDetail(id);
    }

    @ResponseResult
    @RequestMapping("all")
    public List<ScenariosVo> all() {
        List<ScheduleScenarios> scenarios = scenariosService.list();
        return ObjectUtil.copyListProperties(scenarios, ScenariosVo.class);
    }

    @ResponseResult
    @RequestMapping("save")
    public Map<String, String> save(ScenariosVo scenariosVo) {
        return scenariosService.saveScenarios(scenariosVo);
    }

    @ResponseResult
    @RequestMapping("delete/type/{type}/id/{id}")
    public Map<String, String> delete(@PathVariable("type") String type, @PathVariable("id") String id) {
        return scenariosService.deleteScenarios(type, id);
    }
}

