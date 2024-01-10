package cn.cxnxs.scheduler.core;

import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;

/**
 * <p>
 * 代理事件
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
public class Event {

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public JSONObject getPayload() {
        return payload;
    }

    public void setPayload(JSONObject payload) {
        this.payload = payload;
    }

    public void setPayload(String payload) {
        this.payload = JSONObject.parseObject(payload);
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public String toString() {
        return "Events{" +
                "id=" + id +
                ", userId=" + userId +
                ", agentId=" + agentId +
                ", payload='" + payload + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", expiresAt=" + expiresAt +
                '}';
    }
}
