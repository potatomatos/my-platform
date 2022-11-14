package cn.cxnxs.system.controller;

import cn.cxnxs.common.core.entity.request.PageWrapper;
import cn.cxnxs.system.service.IUserService;
import cn.cxnxs.system.vo.PageVO;
import cn.cxnxs.system.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户相关接口
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("users")
    public PageVO<UserVO> selectUsersForPage(@RequestBody PageWrapper<UserVO> wrapper) {
        return userService.selectUsersForPage(wrapper);
    }

}
