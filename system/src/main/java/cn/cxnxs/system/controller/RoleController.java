package cn.cxnxs.system.controller;


import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.core.entity.response.PageResult;
import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.system.service.RoleServiceImpl;
import cn.cxnxs.system.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleServiceImpl roleService;

    @ResponseResult
    @PostMapping("list")
    public List<RoleVO> listRole(@RequestBody RoleVO roleVO) {
        return roleService.listRole(roleVO);
    }

    @ResponseResult
    @PostMapping("page")
    public PageResult<RoleVO> listRole(@RequestBody PageWrapper<RoleVO> pageWrapper) {
        return roleService.pageRole(pageWrapper);
    }

    @ResponseResult
    @GetMapping("/{id}")
    public RoleVO getRoleById(@PathVariable("id") Integer id) {
        return roleService.getRoleById(id);
    }


    @ResponseResult
    @PostMapping("update")
    public Integer update(@RequestBody RoleVO roleVO) {
        return roleService.update(roleVO);
    }

    @ResponseResult
    @PostMapping("add")
    public Integer add(@RequestBody RoleVO roleVO) {
        return roleService.add(roleVO);
    }
}
