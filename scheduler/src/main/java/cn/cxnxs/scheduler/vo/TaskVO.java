package cn.cxnxs.scheduler.vo;

import cn.cxnxs.scheduler.core.Event;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class TaskVO {

    private Integer agentId;

    private String agentName;

    private List<Event> events;

    private String handler;

    /**
     * 失败尝试次数
     */
    private Integer attempts;

    /**
     * 错误信息
     */
    private String lastError;

    /**
     * 运行时间
     */
    private LocalDateTime runAt;

    /**
     * 发生错误时间
     */
    private LocalDateTime failedAt;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    private Integer state;


}
