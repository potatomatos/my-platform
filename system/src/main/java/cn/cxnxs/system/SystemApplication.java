package cn.cxnxs.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 系统模块
 *
 * @author mengjinyuan
 */

@SpringBootApplication(scanBasePackages = {"cn.cxnxs"},exclude ={
        org.activiti.spring.boot.SecurityAutoConfiguration.class,
        SecurityAutoConfiguration.class,
        ManagementWebSecurityAutoConfiguration.class
})
@EnableFeignClients(basePackages = {"cn.cxnxs.common.api"})
@EnableDiscoveryClient
@RefreshScope
@CrossOrigin(origins = "*", maxAge = 3600)
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统服务启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
