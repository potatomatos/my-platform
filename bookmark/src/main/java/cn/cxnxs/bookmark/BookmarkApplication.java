package cn.cxnxs.bookmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 书签服务
 * @author potatomato
 */
@SpringBootApplication(scanBasePackages = {"cn.cxnxs"})
@ServletComponentScan
@EnableTransactionManagement
@EnableFeignClients(basePackages = {"cn.cxnxs.common.api"})
@EnableDiscoveryClient
@RefreshScope
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookmarkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookmarkApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  书签服务启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
