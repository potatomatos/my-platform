package cn.cxnxs.scheduler.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2020-12-10 00:18
 **/
@Getter
@Setter
public class ScenariosVo {
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

    public Integer getValue() {
        if (this.value != null) {
            return this.value;
        }
        return this.id;
    }
}
