package cn.cxnxs.security.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p></p>
 *
 * @author mengjinyuan
 **/
@Data
@ConfigurationProperties(prefix = "oauth.github")
public class GithubOauthProperties {

    private String clientId;

    private String clientSecret;
}
