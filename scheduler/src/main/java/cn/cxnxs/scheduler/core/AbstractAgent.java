package cn.cxnxs.scheduler.core;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>代理抽象类</p>
 *
 * @author mengjinyuan
 * @date 2021-01-21 11:08
 **/
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

}
