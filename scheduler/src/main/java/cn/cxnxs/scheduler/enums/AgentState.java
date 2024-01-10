package cn.cxnxs.scheduler.enums;

/**
 * @author potatomato
 */

public enum AgentState {
    /**
     *
     */
    PAUSE(0, "暂停"),
    /**
     *
     */
    ENABLE(1, "待运行"),
    /**
     *
     */
    WORKING(2, "执行中"),
    /**
     *
     */
    DISABLE(3, "已禁用"),
    ;
    private Integer code;

    private String str;

    AgentState(Integer code, String str) {
        this.code = code;
        this.str = str;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStr() {
        return this.str;
    }

    public static String getStr(Integer code) {
        for (AgentState e : AgentState.values()) {
            if (e.getCode().equals(code)) {
                return e.str;
            }
        }
        return null;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
