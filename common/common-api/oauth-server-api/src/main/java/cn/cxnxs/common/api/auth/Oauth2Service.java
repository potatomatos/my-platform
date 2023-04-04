package cn.cxnxs.common.api.auth;

import cn.cxnxs.common.api.auth.factory.Oauth2ServiceFallbackFactory;
import cn.cxnxs.common.core.entity.response.Result;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * oauth2.0认证接口
 *
 * @author mengjinyuan
 */
@FeignClient(value = "oauth-server", fallbackFactory = Oauth2ServiceFallbackFactory.class)
public interface Oauth2Service {

    /**
     * 申请token
     *
     * @param grant_type
     * @param client_id
     * @param client_secret
     * @param code
     * @param redirect_uri
     */
    @GetMapping("/oauth/token")
    Map<String, String> getAccessToken(@RequestParam("grant_type") String grant_type,
                                       @RequestParam("client_id") String client_id,
                                       @RequestParam("client_secret") String client_secret,
                                       @RequestParam("code") String code,
                                       @RequestParam("redirect_uri") String redirect_uri);

    @GetMapping("/oauth/check_token")
    Map<String,?> checkToken(@RequestParam("token")String token);
    /**
     * 获取公钥
     */
    @GetMapping("/rsa/publicKey")
    Result<Map<String, Object>> getPublicKey();


    /**
     * 获取登录用户信息
     *
     * @return
     */
    @GetMapping("/currentUser")
    Result<JSONObject> currentUser();

    /**
     * 校验token
     * @param accessToken
     * @return
     */
    @GetMapping("/verifyToken")
    Result<JSONObject> verifyToken(String accessToken);

    /**
     * 校验前端路由
     * @param accessToken
     * @param path
     * @return
     */
    @GetMapping("/verifyPage")
    Result<JSONObject> verifyPage(@RequestParam("accessToken")String accessToken, @RequestParam("path")String path);
}
