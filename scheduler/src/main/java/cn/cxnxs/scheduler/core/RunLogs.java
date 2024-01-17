package cn.cxnxs.scheduler.core;

import lombok.Getter;
import lombok.Setter;

/**
 * 运行日志
 */
@Getter
@Setter
public class RunLogs {

    /**
     * 日志类型
     */
    private String type;

    /**
     * 线程ID
     */
    private String threadId;

    /**
     * 日志内容
     */
    private StringBuilder log;

    public static RunLogs create(String threadId) {
        RunLogs runLogs = new RunLogs();
        runLogs.setThreadId(threadId);
        return runLogs;
    }

    public void log(LogType logType, String logger) {
        log.append("[").append(logType).append("]").append(logger).append("\n\r");
    }

    public void info(String logger) {
        this.log(LogType.INFO, logger);
    }

    public void error(String logger) {
        this.log(LogType.ERROR, logger);
    }

    public void warn(String logger) {
        this.log(LogType.WARN, logger);
    }

    @Override
    public String toString() {
        return this.log.toString();
    }

    enum LogType {
        INFO, ERROR, WARN
    }
}
