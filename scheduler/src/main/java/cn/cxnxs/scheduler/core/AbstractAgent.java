package cn.cxnxs.scheduler.core;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
public abstract class AbstractAgent implements IAgent {

    /**
     * 服务配置
     */
    protected JSONObject options;

    /**
     * 服务名称
     */
    protected String name;

    protected Integer id;

    @Override
    public RunResult runAgent() {
        Thread thread = Thread.currentThread();
        RunResult runResult = new RunResult(new JSONArray(), RunLogs.create(thread.getId() + "-" + thread.getName()));
        try {
            runResult.info("======开始运行：{}", getName());
            // 开始前的一些操作
            this.preStart(runResult);
            this.start(runResult);
            runResult.setSuccess(true);
            runResult.info("运行结束");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            runResult.error(e.getMessage());
            runResult.setSuccess(false);
        }
        return runResult;
    }

    @Override
    public IAgent option(JSONObject options) {
        this.options = options;
        return this;
    }

    @Override
    public JSONObject getOptions() {
        return this.options;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public abstract void start(RunResult runResult) throws Exception;


    public abstract void preStart(RunResult runResult) throws Exception;

}
