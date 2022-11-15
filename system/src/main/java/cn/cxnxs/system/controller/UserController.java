package cn.cxnxs.system.controller;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.system.service.IUserService;
import cn.cxnxs.system.vo.PageVO;
import cn.cxnxs.system.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 用户相关接口
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("list")
    public PageVO<UserVO> selectUsersForPage(@RequestBody PageWrapper<UserVO> wrapper) {
        return userService.selectUsersForPage(wrapper);
    }

    @ResponseResult
    @GetMapping("/{id}")
    public UserVO selectOne(@PathVariable("id") Integer id) {
        return userService.getUser(id);
    }

    @ResponseResult
    @PostMapping("update")
    public Integer update(@RequestBody UserVO userVO) {
        return userService.updateUser(userVO);
    }
}
