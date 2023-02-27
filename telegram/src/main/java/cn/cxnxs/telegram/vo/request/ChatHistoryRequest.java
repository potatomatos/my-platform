package cn.cxnxs.telegram.vo.request;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2021-10-14 23:01
 **/
public class ChatHistoryRequest {
    private Long chatId;
    private Long fromMessageId;
    private Integer limit;

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public Long getFromMessageId() {
        return fromMessageId;
    }

    public void setFromMessageId(Long fromMessageId) {
        this.fromMessageId = fromMessageId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "ChatHistoryRequest{" +
                "chatId=" + chatId +
                ", fromMessageId=" + fromMessageId +
                ", limit=" + limit +
                '}';
    }
}
