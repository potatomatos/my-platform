package cn.cxnxs.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 系统模块
 *
 * @author iot
 */
@SpringBootApplication
@EnableFeignClients
@RefreshScope
/**
 * 实现跨域注解
 * origin="*"代表所有域名都可访问
 * maxAge飞行前响应的缓存持续时间的最大年龄，简单来说就是Cookie的有效期 单位为秒
 * 若maxAge是负数,则代表为临时Cookie,不会被持久化,Cookie信息保存在浏览器内存中,浏览器关闭Cookie就消失
 */
@CrossOrigin(origins = "*", maxAge = 3600)
public class SystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统服务启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }
}
