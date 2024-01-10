package cn.cxnxs.scheduler.exception;

/**
 * <p>定时任务异常</p>
 *
 * @author mengjinyuan
 * @date 2022-01-03 22:52
 **/
public class ScheduleException extends RuntimeException {

    public ScheduleException() {
    }

    public ScheduleException(String message) {
        super(message);
    }

    public ScheduleException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScheduleException(Throwable cause) {
        super(cause);
    }

    public ScheduleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
