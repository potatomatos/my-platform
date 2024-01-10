package cn.cxnxs.scheduler.core;

import com.alibaba.fastjson.JSONObject;
import com.arronlong.httpclientutil.exception.HttpProcessException;

import java.util.List;
import java.util.Map;

/**
 * 代理接口
 *
 * @author potatomato
 */
public interface IAgent {

    /**
     * 接收上个代理传来的事件
     *
     * @param event 数据源事件
     * @return 当前对象
     */
    List<Map<String, String>> collect(Event event) throws HttpProcessException;


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
