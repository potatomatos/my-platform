package cn.cxnxs.system.controller;

import cn.cxnxs.common.api.Oauth2Service;
import cn.cxnxs.common.api.domain.UserApiEntity;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.system.service.IPermissionService;
import cn.cxnxs.system.service.IUserService;
import cn.cxnxs.system.vo.UserVO;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("system/api")
@Slf4j
public class SystemController {

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private IUserService userService;

    @Autowired
    private Oauth2Service oauth2Service;

    @Value("${oauth.clientId}")
    private String clientId;
    @Value("${oauth.clientSecret}")
    private String clientSecret;
    @Value("${oauth.redirectUri}")
    private String redirectUri;

    /**
     * 获取token
     */
    @GetMapping("/getAccessToken")
    public Result<Map<String, String>> getAccessToken(String code) {
        log.info("code:{}", code);
        if (StringUtil.isEmpty(code)){
            return Result.failure("code不能为空！");
        }
        log.info("------开始获取token------");
        Map<String, String> accessToken = oauth2Service.getAccessToken(
                "authorization_code",
                clientId,
                clientSecret,
                code,
                redirectUri);
        log.info("token信息：{}", JSON.toJSONString(accessToken));
       return Result.success(accessToken);
    }

    /**
     * 获取放行的路径
     *
     * @param uri      地址
     * @param clientId 客户端id
     * @return
     */
    @GetMapping(value = "permit")
    public Result<Boolean> permit(@RequestParam("uri") String uri, @RequestParam("clientId") String clientId) {
        return Result.success(permissionService.permit(uri, clientId));
    }

    /**
     * 更新用户信息
     *
     * @param userApiEntity 用户信息
     * @return true-成功 false-失败
     */
    @PostMapping("updateUser")
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
    @GetMapping("getUserByName")
    Result<UserApiEntity> getUserByName(@RequestParam("username") String username) {
        UserApiEntity userByName = userService.getUserByName(username);
        return userByName == null ? Result.failure("用户不存在") : Result.success(userByName);
    }
}
