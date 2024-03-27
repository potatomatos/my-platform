package cn.cxnxs.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p></p>
 *
 * @author mengjinyuan
 **/
@Data
@ConfigurationProperties(prefix = "oauth.weixin")
public class WeixinOauthProperties {

    private String clientId;

    private String clientSecret;
}
