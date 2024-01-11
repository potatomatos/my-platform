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
 * agent定义信息
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ScheduleAgentType extends Model<ScheduleAgentType> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * agent类型名称
     */
    private String agentTypeName;

    /**
     * 处理器地址
     */
    private String handler;

    /**
     * 是否定时执行
     */
    private Boolean canBeScheduled;

    /**
     * 是否生成事件
     */
    private Boolean canCreateEvents;

    /**
     * 是否空运行
     */
    private Boolean canDryRun;

    /**
     * 是否接收事件
     */
    private Boolean canReceiveEvents;

    /**
     * 默认定时周期
     */
    private Integer defaultSchedule;

    /**
     * 使用方法
     */
    private String descriptionHtml;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 表单地址
     */
    private String formUrl;

    /**
     * 配置模板
     */
    private String optionsTemplate;

    /**
     * 表单校验规则，如果配置是json类型
     */
    private String optionsSchema;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

}
