package cn.cxnxs.common.web.config;

import cn.cxnxs.common.core.entity.response.ErrorResult;
import cn.cxnxs.common.core.entity.response.Result;
import cn.cxnxs.common.web.exception.ValidationException;
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
        log.error("------全局异常拦截------");
        log.error("异常信息：" + e.getMessage(), e);
        return new ErrorResult(Result.ResultEnum.SYSTEM_EXCEPTION.getCode(), e.getMessage(), null);
    }

    @ExceptionHandler(value = ValidationException.class)
    public ErrorResult validateExceptionHandler(Exception e) {
        log.error("------参数校验失败拦截------");
        log.error("异常信息：" + e.getMessage(), e);
        return new ErrorResult(Result.ResultEnum.BAD_REQUEST.getCode(), e.getMessage(), null);
    }
}
