package cn.cxnxs.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 网关模块
 *
 * @author mengjinyuan
 */
@SpringBootApplication(scanBasePackages = {"cn.cxnxs.gateway"})
@EnableFeignClients(basePackages = {"cn.cxnxs.common.api"})
@EnableDiscoveryClient
@RefreshScope
@CrossOrigin(origins = "*", maxAge = 3600)
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  网关服务启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
