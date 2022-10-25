package cn.cxnxs.common.core.exception;

/**
 * <p>业务异常</p>
 *
 * @author mengjinyuan
 * @date 2022-02-18 09:32
 **/
public class CommonException extends RuntimeException{
    public CommonException() {
    }

    public CommonException(String message) {
        super(message);
    }

    public CommonException(String message, Throwable cause) {
        super(message, cause);
    }

    public CommonException(Throwable cause) {
        super(cause);
    }

    public CommonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
