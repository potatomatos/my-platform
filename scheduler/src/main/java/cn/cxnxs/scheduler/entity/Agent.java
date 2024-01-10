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
 * 爬虫任务配置信息
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Agent extends Model<Agent> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属用户
     */
    private Integer userId;

    /**
     * 服务配置
     */
    private String options;

    /**
     * 服务类型
     */
    private Integer type;

    /**
     * 服务名称
     */
    private String name;

    /**
     * 服务运行周期计划
     */
    private String schedule;

    /**
     * 数据总数
     */
    private Integer dataCount;

    /**
     * 上次检测时间
     */
    private LocalDateTime lastCheckAt;

    /**
     * 上次接收到数据时间
     */
    private LocalDateTime lastReceiveAt;

    /**
     * 上次检查数据源数据id
     */
    private Integer lastCheckedDataId;

    /**
     * 上次发送请求时间
     */
    private LocalDateTime lastWebRequestAt;

    /**
     * 结果数据保存时长
     */
    private Integer keepDataTime;

    /**
     * 上次产生数据时间
     */
    private LocalDateTime lastDataIme;

    /**
     * 上次产生错误时间
     */
    private LocalDateTime lastErrorLogTime;

    /**
     * 数据是否立即传播到下一个服务
     */
    private Boolean propagateImmediately;

    /**
     * 禁用状态
     */
    private Integer state;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

}
