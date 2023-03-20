package cn.cxnxs.bookmark.vo.response;

import lombok.Data;

/**
 * <p>websocket消息</p>
 *
 * @author mengjinyuan
 * @date 2022-03-30 23:33
 **/
@Data
public class WebsocketVo {

    /**
     * 时间戳
     */
    private long timestamp;

    /**
     * 消息类型
     */
    private String msgType;

    /**
     * 发送者
     */
    private String fromUser;

    /**
     * 接收者
     */
    private String toUser;
    /**
     * 消息体
     */
    private Object msg;
}
