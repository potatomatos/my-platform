package cn.cxnxs.common.web.config;

import cn.cxnxs.common.core.entity.response.ErrorResult;
import cn.cxnxs.common.core.entity.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * <p>全局异常拦截器</p>
 *
 * @author mengjinyuan
 * @date 2019-11-19
 */
@Slf4j
@ControllerAdvice
@ResponseBody
public class GlobalExceptionResolver {

    @ExceptionHandler(value = Exception.class)
    public ErrorResult errorHandler(Exception e) {
        log.info("------全局异常拦截------");
        log.error("异常信息：" + e.getMessage(), e);
        return new ErrorResult(Result.ResultEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage(), null);
    }
}
