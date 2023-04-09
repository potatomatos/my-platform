package cn.cxnxs.bookmark.controller;

import cn.cxnxs.common.api.auth.Oauth2Service;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.core.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("system")
public class SystemController {

    @Value("${oauth.clientId}")
    private String clientId;
    @Value("${oauth.clientSecret}")
    private String clientSecret;
    @Value("${oauth.redirectUri}")
    private String redirectUri;

    @Autowired
    private Oauth2Service oauth2Service;

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
        try {
            Map<String, String> accessToken = oauth2Service.getAccessToken(
                    "authorization_code",
                    clientId,
                    clientSecret,
                    code,
                    redirectUri);
            log.info("token信息：{}", JSON.toJSONString(accessToken));
            return Result.success(accessToken);
        }catch (Exception e) {
            return Result.failure("认证失败:"+e.getMessage());
        }
    }
}
