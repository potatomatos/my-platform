package cn.cxnxs.scheduler.core;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 运行日志
 */
@Getter
@Setter
public class RunLogs {

    private static final Logger logger = LoggerFactory.getLogger(RunLogs.class);

    /**
     * 线程ID
     */
    private String threadId;

    /**
     * 日志内容
     */
    private StringBuilder log;

    public RunLogs() {
        this.log = new StringBuilder();
    }

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
        RunLogs.logger.info(logger);
    }

    public void error(String logger) {
        this.log(LogType.ERROR, logger);
        RunLogs.logger.error(logger);
    }

    public void warn(String logger) {
        this.log(LogType.WARN, logger);
        RunLogs.logger.warn(logger);
    }

    @Override
    public String toString() {
        return this.log.toString();
    }

    enum LogType {
        INFO, ERROR, WARN
    }
}
