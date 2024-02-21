package cn.cxnxs.scheduler.core;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

/**
 * 代理接口
 *
 * @author potatomato
 */
public interface IAgent extends Serializable {

    /**
     * 执行
     */
    RunResult runAgent();

    /**
     * 设置配置参数
     *
     * @param options 配置
     * @return 当前对象
     */
    IAgent option(JSONObject options);

    /**
     * 获取配置文件信息
     *
     * @return
     */
    JSONObject getOptions();

    /**
     * 名称
     */
    void setName(String name);

    /**
     * 获取任务名称
     *
     * @return
     */
    String getName();

}
