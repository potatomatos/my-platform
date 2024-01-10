package cn.cxnxs.scheduler.core;

import com.alibaba.fastjson.JSONObject;

/**
 * <p>代理抽象类</p>
 *
 * @author mengjinyuan
 * @date 2021-01-21 11:08
 **/
public abstract class AbstractAgent implements IAgent {

    /**
     * 服务配置
     */
    private JSONObject options;

    /**
     * 服务名称
     */
    private String name;


    public JSONObject getOptions() {
        return options;
    }

    public void setOptions(JSONObject options) {
        this.options = options;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
