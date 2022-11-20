package cn.cxnxs.system.controller;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.system.entity.SysDict;
import cn.cxnxs.system.service.IDictService;
import cn.cxnxs.system.vo.DictVO;
import cn.cxnxs.system.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>字典接口</p>
 *
 * @author mengjinyuan
 * @date 2022-11-18 00:00
 **/
@RestController
@RequestMapping("dict")
public class DictController {

    @Autowired
    private IDictService dictService;

    @PostMapping("list")
    public PageVO<DictVO> list(@RequestBody PageWrapper<DictVO> pageWrapper) {
        return dictService.list(pageWrapper);
    }

    @ResponseResult
    @PostMapping("add")
    public Integer addDict(@RequestBody DictVO dictVO) {
        return dictService.addDict(dictVO);
    }

    @ResponseResult
    @PostMapping("update")
    public Integer updateDict(@RequestBody DictVO dictVO) {
        return dictService.updateDict(dictVO);
    }

    @ResponseResult
    @GetMapping("/{id}")
    public SysDict detail(@PathVariable("id") Integer id) {
        return dictService.dictInfo(id);
    }

    @ResponseResult
    @PostMapping("del/{id}")
    public Integer delete(@PathVariable("id") Integer id) {
        return dictService.delete(id);
    }

    @ResponseResult
    @GetMapping("types")
    public List<DictVO> list() {
        return dictService.getDictTypes();
    }
}
