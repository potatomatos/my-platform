package cn.cxnxs.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 系鉴权块
 *
 * @author mengjinyuan
 */

@SpringBootApplication(scanBasePackages = {"cn.cxnxs"})
@EnableFeignClients
@RefreshScope
@CrossOrigin(origins = "*", maxAge = 3600)
public class OauthServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OauthServerApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  鉴权服务启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
