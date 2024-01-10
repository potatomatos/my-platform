package cn.cxnxs.scheduler.vo;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2021-01-08 13:38
 **/
public class LinksVO implements Serializable {
    private Integer id;

    private Integer sourceId;

    private Integer receiverId;

    private Integer eventIdAtCreation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Integer getEventIdAtCreation() {
        return eventIdAtCreation;
    }

    public void setEventIdAtCreation(Integer eventIdAtCreation) {
        this.eventIdAtCreation = eventIdAtCreation;
    }

    @Override
    public String toString() {
        return "LinksVO{" +
                "id=" + id +
                ", sourceId=" + sourceId +
                ", receiverId=" + receiverId +
                ", eventIdAtCreation=" + eventIdAtCreation +
                '}';
    }
}
