package cn.cxnxs.scheduler.core;

import com.alibaba.fastjson.JSONArray;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RunResult {

    /**
     * 抓取的内容
     */
    private JSONArray payload;

    /**
     * 运行日志
     */
    private RunLogs runLogs;

    public RunResult(JSONArray payload, RunLogs runLogs) {
        this.payload = payload;
        this.runLogs = runLogs;
    }

    public void log(String logger) {
        this.runLogs.info(logger);
    }

    public void error(String logger) {
        this.runLogs.error(logger);
    }

    public void info(String logger) {
        this.runLogs.info(logger);
    }
}
