package cn.cxnxs.scheduler.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 任务场景
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ScheduleScenarios extends Model<ScheduleScenarios> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
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

}
