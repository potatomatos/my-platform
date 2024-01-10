package cn.cxnxs.scheduler.exception;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2020-11-17 10:51
 **/
public class AgentNotFoundException extends RuntimeException {
    public AgentNotFoundException() {
        super();
    }

    public AgentNotFoundException(String message) {
        super(message);
    }
}
