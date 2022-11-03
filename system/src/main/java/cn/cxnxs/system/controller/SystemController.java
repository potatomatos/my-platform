package cn.cxnxs.system.controller;

import cn.cxnxs.common.api.Oauth2Service;
import cn.cxnxs.common.api.domain.UserApiEntity;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.system.service.IPermissionService;
import cn.cxnxs.system.service.IUserService;

import cn.cxnxs.system.vo.UserVO;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Controller
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

    @RequestMapping("/")
    public Result<String> test() {
        return Result.success("登录成功");
    }

    /**
     * 登陆后回调方法
     */
    @RequestMapping("/callback")
    public void callback(String code, HttpServletResponse httpServletResponse) throws IOException {
        log.info("code:{}", code);
        log.info("------开始获取token------");
        Map<String, String> accessToken = oauth2Service.getAccessToken(
                "authorization_code",
                clientId,
                clientSecret,
                code,
                redirectUri);
        log.info("token信息：{}", JSON.toJSONString(accessToken));
        httpServletResponse.setHeader("access_token", accessToken.get("access_token"));
        httpServletResponse.sendRedirect("/");
    }

    /**
     * 获取放行的路径
     *
     * @param uri      地址
     * @param clientId 客户端id
     * @return
     */
    @ResponseBody
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
    @ResponseBody
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
    @ResponseBody
    @GetMapping("getUserByName")
    Result<UserApiEntity> getUserByName(@RequestParam("username") String username) {
        UserApiEntity userByName = userService.getUserByName(username);
        return userByName == null ? Result.failure("用户不存在") : Result.success(userByName);
    }
}
