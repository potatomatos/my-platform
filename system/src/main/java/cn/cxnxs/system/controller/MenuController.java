package cn.cxnxs.system.controller;


import cn.cxnxs.common.core.entity.TreeVo;
import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.system.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 菜单相关接口
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @ResponseResult
    @GetMapping("userMenus")
    public List<TreeVo> getUserMenusTree(){
        return menuService.getUserMenusTree();
    }
}
