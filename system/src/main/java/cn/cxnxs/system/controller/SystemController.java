package cn.cxnxs.system.controller;

import cn.cxnxs.common.api.domain.UserApiEntity;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.system.service.IPermissionService;
import cn.cxnxs.system.service.IUserService;

import cn.cxnxs.system.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("system/api")
public class SystemController {

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private IUserService userService;

    /**
     * 获取放行的路径
     *
     * @param uri      地址
     * @param clientId 客户端id
     * @return
     */
    @GetMapping(value = "permit")
    public Result<Boolean> permit(String uri, String clientId) {
        return Result.success(permissionService.permit(uri, clientId));
    }

    /**
     * 更新用户信息
     *
     * @param userApiEntity 用户信息
     * @return true-成功 false-失败
     */
    @GetMapping("updateUser")
    Result<Boolean> updateUser(UserApiEntity userApiEntity) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userApiEntity, userVO);
        return Result.success(userService.updateUser(userVO) > 0);
    }


    /**
     * 更新用户信息
     *
     * @param username 用户名
     */
    @GetMapping("getUserByName")
    Result<UserApiEntity> getUserByName(String username) {
        UserApiEntity userByName = userService.getUserByName(username);
        return userByName == null?Result.failure("用户不存在"): Result.success(userByName);
    }
}
