package cn.cxnxs.scheduler.vo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2020-12-10 00:18
 **/
public class ScenariosVo extends BaseVo {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 描述说明
     */
    private String description;

    /**
     * 是否公开
     */
    private Boolean isPublic;

    /**
     * 标签背景颜色
     */
    private String tagBgColor;

    /**
     * 标签前景颜色
     */
    private String tagFgColor;

    /**
     * 图标
     */
    private String icon;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 代理数量
     */
    private Long agentCount;

    /**
     * 包含的代理
     */
    private List<AgentVo> agents;

    private List<Integer> agentIds;

    /**
     * 禁用状态
     */
    private Boolean disabled = false;

    private Boolean selected = false;
    private Integer value;

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Integer getValue() {
        if (this.value != null) {
            return this.value;
        }
        return this.id;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Integer> getAgentIds() {
        return agentIds;
    }

    public void setAgentIds(List<Integer> agentIds) {
        this.agentIds = agentIds;
    }

    public List<AgentVo> getAgents() {
        return agents;
    }

    public void setAgents(List<AgentVo> agents) {
        this.agents = agents;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public String getTagBgColor() {
        return tagBgColor;
    }

    public void setTagBgColor(String tagBgColor) {
        this.tagBgColor = tagBgColor;
    }

    public String getTagFgColor() {
        return tagFgColor;
    }

    public void setTagFgColor(String tagFgColor) {
        this.tagFgColor = tagFgColor;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    public Long getAgentCount() {
        return agentCount;
    }

    public void setAgentCount(Long agentCount) {
        this.agentCount = agentCount;
    }

    @Override
    public String toString() {
        return "ScenariosVo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                ", description='" + description + '\'' +
                ", isPublic=" + isPublic +
                ", tagBgColor='" + tagBgColor + '\'' +
                ", tagFgColor='" + tagFgColor + '\'' +
                ", icon='" + icon + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", agentCount=" + agentCount +
                '}';
    }
}
