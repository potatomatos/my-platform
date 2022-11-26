package cn.cxnxs.common.api.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixCommandProperties;
import feign.Feign;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Target;
import feign.hystrix.SetterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;

@Configuration
public class FeignConfiguration implements RequestInterceptor {

    /**
     * 传递header请求头
     * @param requestTemplate
     */
    @Override
    public void apply(RequestTemplate requestTemplate) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        assert attributes != null;
        HttpServletRequest request = attributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String name = headerNames.nextElement();
                String values = request.getHeader(name);
                // 跳过 content-length
                if ("content-length".equals(name)){
                    continue;
                }
                requestTemplate.header(name, values);
            }
        }
    }

    /**
     * 开启Hystrix后feign之间的方法调用就会默认启动新的线程执行和主程序不在一个线程中，
     * 因此如果上下文中存在ThreadLocal变量，在该方法中就失效了。因此一般可以通过设置CommandProperties注解属性，设置线程就可以了。
     * 在和Feign整合后，用户无法配置Feign的ComandProperties，但是可以通过配置Bean的形式配置。
     * @return
     */
    @Bean
    public SetterFactory setterFactory(){
        return (target, method) -> {
            String groupKey = target.name();
            String commandKey = Feign.configKey(target.type(), method);

            HystrixCommandProperties.Setter setter = HystrixCommandProperties.Setter()
                    //设置统计指标60秒为一个时间窗口
                    .withMetricsRollingStatisticalWindowInMilliseconds(1000 * 60)
                    //超过80%失败率
                    .withCircuitBreakerErrorThresholdPercentage(80)
                    //操作5个开启短路器
                    .withCircuitBreakerRequestVolumeThreshold(5)
                    //设置线程隔离
                    .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                    //设置断路器的开启时间为60秒
                    .withCircuitBreakerSleepWindowInMilliseconds(1000 * 60);
            return HystrixCommand.Setter
                    .withGroupKey(HystrixCommandGroupKey.Factory.asKey(groupKey))
                    .andCommandKey(HystrixCommandKey.Factory.asKey(commandKey))
                    .andCommandPropertiesDefaults(setter);
        };
    }
}
