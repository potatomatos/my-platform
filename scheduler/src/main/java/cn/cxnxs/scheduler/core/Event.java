package cn.cxnxs.scheduler.core;

import com.alibaba.fastjson.JSONObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 代理事件
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
@Getter
@Setter
@ToString
public class Event implements Serializable {

    private Integer id;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 所属代理
     */
    private Integer agentId;

    /**
     * 内容
     */
    private JSONObject payload;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 过期时间
     */
    private LocalDateTime expiresAt;
}
