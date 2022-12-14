package cn.cxnxs.security.controller;


import cn.cxnxs.common.cache.RedisUtils;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.exception.CommonException;
import cn.cxnxs.common.core.utils.StringUtil;
import cn.cxnxs.common.web.annotation.ResponseResult;
import cn.cxnxs.security.constants.RedisKeyPrefix;
import cn.cxnxs.security.entity.JwtUser;
import cn.cxnxs.security.entity.UserPasswordAuthenticationToken;
import cn.cxnxs.security.service.impl.AuthService;
import cn.cxnxs.security.utils.ImageUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.KeyPair;
import java.security.Principal;
import java.security.interfaces.RSAPublicKey;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class OauthController {

    @Autowired
    private KeyPair keyPair;

    @Autowired
    private HttpServletResponse httpServletResponse;

    @Autowired
    private AuthService authService;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private TokenStore jdbcTokenStore;

    private static final String REDIS_KEY = "USER_PAGES:";

    /**
     * 获取公钥
     */
    @GetMapping("/rsa/publicKey")
    public Result<Map<String, Object>> getPublicKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return Result.success(new JWKSet(key).toJSONObject());
    }

    /**
     * 验证码
     */
    @CrossOrigin(origins = "*")
    @RequestMapping("captcha")
    public void captcha() throws IOException {
        String captcha = StringUtil.randomString(4);
        String key = RedisKeyPrefix.KEY_CAPTCHA + authService.getIpAddr();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageUtil.buildImageVerify(captcha, 100, 38, bos);
        redisUtils.set(key, captcha, 5 * 60);
        httpServletResponse.setContentType("image/png");
        OutputStream os = httpServletResponse.getOutputStream();
        os.write(bos.toByteArray());
        os.flush();
        os.close();
    }

    /**
     * 获取授权的用户信息
     *
     * @param principal 当前用户
     * @return 授权信息
     */
    @ResponseResult
    @GetMapping("currentUser")
    public JSONObject user(Principal principal) {
        if (principal!=null){
            UserPasswordAuthenticationToken userPasswordAuthenticationToken = (UserPasswordAuthenticationToken) principal;
            return JSONObject.parseObject(JSON.toJSONString(userPasswordAuthenticationToken.getJwtUser()));
        }else {
            throw new CommonException("登录信息获取失败，请登录后再调用");
        }

    }

    @GetMapping("verifyToken")
    public Result<Object> verifyToken() {
        return Result.success();
    }

    /**
     * 菜单权限校验
     * @return
     */
    @GetMapping("verifyPage")
    public Result<Object> verifyPage(Principal principal,String path) {
        UserPasswordAuthenticationToken userPasswordAuthenticationToken = (UserPasswordAuthenticationToken) principal;
        JwtUser jwtUser = userPasswordAuthenticationToken.getJwtUser();
        List<String> userMenus = jwtUser.getUserMenuPaths();
        if (!userMenus.contains(path)){
            return Result.failure(Result.ResultEnum.FORBIDDEN,
                    Result.ResultEnum.FORBIDDEN.getInfo(),
                    Result.ResultEnum.FORBIDDEN.getResult());
        }
        return Result.success();
    }
}
