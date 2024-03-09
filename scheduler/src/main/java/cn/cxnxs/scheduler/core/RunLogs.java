package cn.cxnxs.scheduler.core;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;

/**
 * 运行日志
 */
@Getter
@Setter
public class RunLogs implements Serializable {

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

    public void log(LogType logType, String logger, Object... args) {
        // 获取调用 RunLogs.log 方法的堆栈信息
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        StackTraceElement previousCaller = stackTraceElements[4]; // 获取上一级的堆栈信息
        // 构造带有类名、方法名和行号的日志信息
        String stackInfo = previousCaller.getClassName() + "." + previousCaller.getMethodName() + ":" + previousCaller.getLineNumber() + " - ";

        logger = replacePlaceholder(logger, args);
        log.append(LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS")))
                .append("[").append(logType).append("] ")
                .append(stackInfo).append(logger).append("\n\r");
    }

    public static String replacePlaceholder(String logger, Object... replacement) {
        for (Object value : replacement) {
            logger = logger.replaceFirst("\\{\\}", Matcher.quoteReplacement(value.toString()));
        }
        return logger;
    }

    public void info(String logger, Object... args) {
        this.log(LogType.INFO, logger, args);
        RunLogs.logger.info(logger, args);
    }

    public void error(String logger, Object... args) {
        this.log(LogType.ERROR, logger, args);
        RunLogs.logger.error(logger, args);
    }

    public void warn(String logger, Object... args) {
        this.log(LogType.WARN, logger, args);
        RunLogs.logger.warn(logger, args);
    }

    @Override
    public String toString() {
        return this.log.toString();
    }

    enum LogType {
        INFO, ERROR, WARN
    }
}
