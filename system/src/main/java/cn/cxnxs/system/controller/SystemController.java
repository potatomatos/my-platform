package cn.cxnxs.system.controller;

import cn.cxnxs.common.api.auth.Oauth2Service;
import cn.cxnxs.common.api.system.domain.UserApiEntity;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.system.service.PermissionServiceImpl;
import cn.cxnxs.system.service.UserServiceImpl;
import cn.cxnxs.system.vo.UserVO;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("system")
@Slf4j
public class SystemController {

    @Autowired
    private PermissionServiceImpl permissionService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private Oauth2Service oauth2Service;

    @Value("${oauth.clientSecret}")
    private String clientSecret;

    /**
     * 获取token
     */
    @GetMapping("api/getAccessToken")
    public Result<Map<String, String>> getAccessToken(String code, String clientId, String redirectUri) {
        log.info("code:{}", code);
        if (StringUtil.isEmpty(code)) {
            return Result.failure("code不能为空！");
        }
        log.info("------开始获取token------");
        try {
            Map<String, String> accessToken = oauth2Service.getAccessToken(
                    "authorization_code",
                    clientId,
                    clientSecret,
                    code,
                    redirectUri);
            log.info("token信息：{}", JSON.toJSONString(accessToken));
            return Result.success(accessToken);
        } catch (Exception e) {
            return Result.failure("认证失败:" + e.getMessage());
        }
    }

    /**
     * 获取放行的路径
     *
     * @param uri      地址
     * @param clientId 客户端id
     */
    @GetMapping(value = "api/permit")
    public Result<Boolean> permit(@RequestParam("uri") String uri, @RequestParam("clientId") String clientId) {
        return Result.success(permissionService.permit(uri, clientId));
    }

    /**
     * 更新用户信息
     *
     * @param userApiEntity 用户信息
     * @return true-成功 false-失败
     */
    @PostMapping("api/updateUser")
    Result<Boolean> updateUser(@RequestBody UserApiEntity userApiEntity) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userApiEntity, userVO);
        return Result.success(userService.updateUser(userVO) > 0);
    }


    /**
     * 更新用户信息
     *
     * @param username 用户名
     */
    @GetMapping("api/getUserByName")
    Result<UserApiEntity> getUserByName(@RequestParam("username") String username) {
        UserApiEntity userByName = userService.getUserByName(username);
        return userByName == null ? Result.failure("用户不存在") : Result.success(userByName);
    }
}
