package cn.cxnxs.security.controller;


import cn.cxnxs.common.core.entity.response.Result;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.KeyPair;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

@RestController
public class OauthController {

    @Autowired
    private KeyPair keyPair;

    /**
     * 获取公钥
     */
    @GetMapping("/rsa/publicKey")
    public Result<Map<String, Object>> getPublicKey() {
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAKey key = new RSAKey.Builder(publicKey).build();
        return Result.success(new JWKSet(key).toJSONObject());
    }
}
