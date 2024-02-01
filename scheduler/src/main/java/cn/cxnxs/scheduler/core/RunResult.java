package cn.cxnxs.scheduler.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RunResult {

    /**
     * 抓取的内容
     */
    private JSONArray payload;

    private String payloadString = "";

    /**
     * 运行日志
     */
    private RunLogs runLogs;

    /**
     * 成功失败标记
     */
    private Boolean success;

    public RunResult(JSONArray payload, RunLogs runLogs) {
        this.payload = payload;
        this.runLogs = runLogs;
    }

    public void setPayload(JSONArray payload) {
        this.payload = payload;
        this.payloadString = this.payload.toString(SerializerFeature.PrettyFormat);
    }

    public void log(String logger, Object... args) {
        this.runLogs.info(logger, args);
    }

    public void error(String logger, Object... args) {
        this.runLogs.error(logger, args);
    }

    public void info(String logger, Object... args) {
        this.runLogs.info(logger, args);
    }
}
