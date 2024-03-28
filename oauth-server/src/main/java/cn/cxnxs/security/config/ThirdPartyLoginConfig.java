package cn.cxnxs.security.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(value = {GithubOauthProperties.class})
public class ThirdPartyLoginConfig {
}
