package cn.cxnxs.scheduler.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2021-01-08 13:38
 **/
@Getter
@Setter
public class LinksVO implements Serializable {
    private Integer id;

    private Integer sourceId;

    private Integer receiverId;

    private Integer eventIdAtCreation;
}
