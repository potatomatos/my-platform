package cn.cxnxs.scheduler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

@EnableAsync
@SpringBootApplication(scanBasePackages = {"cn.cxnxs"})
@ServletComponentScan
@EnableTransactionManagement
@EnableFeignClients
@EnableDiscoveryClient
@RefreshScope
@CrossOrigin(origins = "*", maxAge = 3600)
public class SchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulerApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  调度采集服务启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
