package cn.cxnxs.scheduler.core;

import com.alibaba.fastjson.JSONObject;

/**
 * 代理接口
 *
 * @author potatomato
 */
public interface IAgent {

    /**
     * 执行
     *
     * @param event
     * @return
     */
    RunResult runAgent(Event event);


    /**
     * 获取状态
     *
     * @return int
     */
    int getStatus();

    /**
     * 设置配置参数
     *
     * @param options 配置
     * @return 当前对象
     */
    IAgent option(JSONObject options);

}
