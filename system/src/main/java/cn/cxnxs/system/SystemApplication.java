package cn.cxnxs.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 系统模块
 *
 * @author mengjinyuan
 */

@SpringBootApplication(scanBasePackages = {"cn.cxnxs"})
@MapperScan("cn.cxnxs.system.mapper")
@EnableFeignClients
@RefreshScope
@CrossOrigin(origins = "*", maxAge = 3600)
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统服务启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
