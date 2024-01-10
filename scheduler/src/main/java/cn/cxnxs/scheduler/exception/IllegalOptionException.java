package cn.cxnxs.scheduler.exception;

/**
 * <p>配置错误异常</p>
 *
 * @author mengjinyuan
 * @date 2021-01-24 00:39
 **/
public class IllegalOptionException extends RuntimeException {

    public IllegalOptionException() {
    }

    public IllegalOptionException(String message) {
        super(message);
    }
}
