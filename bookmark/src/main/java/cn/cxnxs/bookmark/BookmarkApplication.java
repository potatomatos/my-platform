package cn.cxnxs.bookmark;

import cn.cxnxs.bookmark.websocket.WebSocketServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 书签服务
 * @author potatomato
 */
@EnableAsync
@SpringBootApplication(scanBasePackages = {"cn.cxnxs"})
@ServletComponentScan
@EnableTransactionManagement
@EnableFeignClients(basePackages = {"cn.cxnxs.common.api"})
@EnableDiscoveryClient
@RefreshScope
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookmarkApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(BookmarkApplication.class);
        ConfigurableApplicationContext configurableApplicationContext = springApplication.run(args);
        //解决WebSocket不能注入的问题
        WebSocketServer.setApplicationContext(configurableApplicationContext);
        System.out.println("(♥◠‿◠)ﾉﾞ  书签服务启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
