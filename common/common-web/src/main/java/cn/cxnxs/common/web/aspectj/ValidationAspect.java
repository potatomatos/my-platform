package cn.cxnxs.common.web.aspectj;

import cn.cxnxs.common.web.utils.ValidationUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 参数校验
 */
@Aspect
@Component
public class ValidationAspect {

    @Pointcut("@annotation(cn.cxnxs.common.web.annotation.Validation)")
    private void parameterPointCut() {
    }

    /**
     * 处理
     *
     * @param joinPoint
     */
    @Around("parameterPointCut()")
    public Object validateParameter(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] paramValues = joinPoint.getArgs();
        for (Object paramValue : paramValues) {
            ValidationUtil.validate(paramValue);
        }
        return joinPoint.proceed(paramValues);
    }

}
