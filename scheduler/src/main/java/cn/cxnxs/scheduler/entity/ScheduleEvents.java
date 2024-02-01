package cn.cxnxs.scheduler.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ScheduleEvents extends Model<ScheduleEvents> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
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
     * 关联的任务Id
     */
    private Integer taskId;

    /**
     * 内容
     */
    private String payload;

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

    /**
     * 占用线程id
     */
    private String lockedBy;

}
