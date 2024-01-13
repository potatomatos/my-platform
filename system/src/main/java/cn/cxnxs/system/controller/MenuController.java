package cn.cxnxs.system.controller;


import cn.cxnxs.common.core.entity.TreeVo;
import cn.cxnxs.common.core.utils.ObjectUtil;
import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.system.entity.SysMenu;
import cn.cxnxs.system.service.MenuServiceImpl;
import cn.cxnxs.system.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 菜单相关接口
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private MenuServiceImpl menuService;

    @ResponseResult
    @GetMapping("userMenus")
    public List<TreeVo> getUserMenusTree() {
        return menuService.getUserMenusTree();
    }

    @ResponseResult
    @GetMapping("menuTree")
    public List<TreeVo> getMenusTree() {
        return menuService.getMenusTree();
    }

    @ResponseResult
    @PostMapping("add")
    public Integer add(@RequestBody SysMenu sysMenu) {
        return menuService.addMenu(sysMenu);
    }

    @ResponseResult
    @PostMapping("update")
    public Integer update(@RequestBody SysMenu sysMenu) {
        return menuService.updateMenu(sysMenu);
    }

    @ResponseResult
    @PostMapping("delete/{id}")
    public Integer deleteMenu(@PathVariable("id") Integer id) {
        return menuService.deleteMenu(id);
    }

    @ResponseResult
    @GetMapping("{id}")
    public MenuVO menuDetail(@PathVariable("id") Integer id) {
        SysMenu sysMenu = new SysMenu().selectById(id);
        MenuVO menuVO = new MenuVO();
        ObjectUtil.transValues(sysMenu, menuVO);
        MenuVO parent = new MenuVO();
        if (menuVO.getParentId() != null) {
            SysMenu sysParent = new SysMenu().selectById(menuVO.getParentId());
            if (sysParent != null) {
                ObjectUtil.transValues(sysParent, parent);
            }
        }
        menuVO.setParent(parent);
        return menuVO;
    }

    @ResponseResult
    @GetMapping("badge")
    public Integer badge() {
        return 500;
    }
}
