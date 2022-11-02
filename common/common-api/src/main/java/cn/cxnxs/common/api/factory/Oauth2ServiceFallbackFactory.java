package cn.cxnxs.common.api.factory;


import cn.cxnxs.common.api.Oauth2Service;
import cn.cxnxs.common.core.entity.response.Result;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;


/**
 * 服务降级
 */
@Slf4j
@Component
public class Oauth2ServiceFallbackFactory implements FallbackFactory<Oauth2Service> {

    @Override
    public Oauth2Service create(Throwable throwable) {

        return new Oauth2Service() {

            @Override
            public Map<String, String> getAccessToken(String grant_type, String client_id, String client_secret, String code, String redirect_uri) {
                log.error("accessToken获取失败");
                return null;
            }

            @Override
            public Result<Map<String, Object>> getPublicKey() {
                log.error("公钥获取失败");
                return Result.failure("公钥获取失败");
            }
        };
    }
}
