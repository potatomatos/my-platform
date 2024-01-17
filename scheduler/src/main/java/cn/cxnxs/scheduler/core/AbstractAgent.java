package cn.cxnxs.scheduler.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * <p>代理抽象类</p>
 *
 * @author mengjinyuan
 * @date 2021-01-21 11:08
 **/
@Slf4j
@Getter
@Setter
public abstract class AbstractAgent implements IAgent {

    /**
     * 服务配置
     */
    private JSONObject options;

    /**
     * 服务名称
     */
    private String name;

    public RunResult runAgent(Event event) {
        Thread thread = Thread.currentThread();
        RunResult runResult = new RunResult(new JSONArray(), RunLogs.create(thread.getId() + "-" + thread.getName()));
        try {
            this.start(event, runResult);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            runResult.error(e.getMessage());
        }
        return runResult;
    }

    public abstract void start(Event event, RunResult runResult) throws Exception;
}
