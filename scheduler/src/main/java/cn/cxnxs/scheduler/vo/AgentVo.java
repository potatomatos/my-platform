package cn.cxnxs.scheduler.vo;

import cn.cxnxs.scheduler.enums.AgentState;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 爬虫任务配置信息
 * </p>
 *
 * @author mengjinyuan
 * @since 2020-11-10
 */
@Getter
@Setter
public class AgentVo {

    /**
     * 主键
     */
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

    private Integer value;

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

    private String keepDataTimeStr;
    /**
     * 禁用状态
     */
    private Boolean disabled = false;

    private Boolean selected = false;

    private String receivers;

    private String scenarioIds;

    private String sources;

    private List<AgentVo> sourceAgents = new ArrayList<>();

    private List<AgentVo> receiverAgents = new ArrayList<>();

    private List<ScenariosVo> scenarios = new ArrayList<>();

    private AgentTypeVo agentType;

    private String stateStr;

    private Integer scenarioId;

    private Boolean hasSources;

    private Boolean hasReceivers;


    public Boolean getHasSources() {
        if (this.sourceAgents != null && this.sourceAgents.size() != 0) {
            return true;
        }
        return hasSources;
    }

    public Boolean getHasReceivers() {
        if (this.receiverAgents != null && this.receiverAgents.size() != 0) {
            return true;
        }
        return this.hasReceivers;
    }

    public String getStateStr() {
        if (this.stateStr == null) {
            this.stateStr = AgentState.getStr(this.state);
        }
        return stateStr;
    }

    public String getKeepDataTimeStr() {
        this.keepDataTimeStr = AgentTypeVo.KeepEventsTime.getDesc(this.keepDataTime);
        return this.keepDataTimeStr;
    }

    public Integer getValue() {
        return this.id;
    }
}