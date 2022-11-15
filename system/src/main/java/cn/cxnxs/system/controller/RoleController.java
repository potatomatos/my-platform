package cn.cxnxs.system.controller;


import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.system.service.IRoleService;
import cn.cxnxs.system.vo.RoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    @ResponseResult
    @PostMapping("list")
    public List<RoleVO> listRole(@RequestBody RoleVO roleVO){
        return roleService.listRole(roleVO);
    }
}
