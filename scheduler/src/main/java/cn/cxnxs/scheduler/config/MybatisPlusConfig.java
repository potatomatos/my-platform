package cn.cxnxs.scheduler.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2020-10-16 23:48
 **/
@MapperScan("cn.cxnxs.scheduler.mapper")
@Aspect
@Configuration
public class MybatisPlusConfig {

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        return interceptor;
    }

    /**
     * 配置织入点
     */
    @Pointcut("execution(public * com.baomidou.mybatisplus.core.mapper.BaseMapper.selectOne(..))")
    public void selectOneAspect() {
    }

    @Before("selectOneAspect()")
    public void beforeSelect(JoinPoint point) {
        Object arg = point.getArgs()[0];
        if (arg instanceof AbstractWrapper) {
            ((AbstractWrapper) arg).last("limit 1");
        }
    }
}
