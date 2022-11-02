package cn.cxnxs.common.api;

import cn.cxnxs.common.api.constants.ServiceNameConstants;
import cn.cxnxs.common.api.factory.SystemServiceFallbackFactory;
import cn.cxnxs.common.core.entity.response.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * oauth2.0认证接口
 * @author mengjinyuan
 */
@FeignClient(value = ServiceNameConstants.AUTH_SERVICE, fallbackFactory = SystemServiceFallbackFactory.class)
public interface Oauth2Service {

    /**
     * 申请token
     * @param grant_type
     * @param client_id
     * @param client_secret
     * @param code
     * @param redirect_uri
     */
    @GetMapping("/oauth/token")
    Map<String,String> getAccessToken(@RequestParam("grant_type")String grant_type,
                          @RequestParam("client_id")String client_id,
                          @RequestParam("client_secret")String client_secret,
                          @RequestParam("code")String code,
                          @RequestParam("redirect_uri")String redirect_uri);

    /**
     * 获取公钥
     */
    @GetMapping("/rsa/publicKey")
    Result<Map<String, Object>> getPublicKey();

}
