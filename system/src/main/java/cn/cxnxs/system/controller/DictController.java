package cn.cxnxs.system.controller;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.system.service.IDictService;
import cn.cxnxs.system.vo.DictVO;
import cn.cxnxs.system.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("list")
    public PageVO<DictVO> list(@RequestBody PageWrapper<DictVO> pageWrapper){
        return dictService.list(pageWrapper);
    }
}
