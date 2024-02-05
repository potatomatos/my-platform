package cn.cxnxs.scheduler.enums;

import lombok.Getter;

@Getter
public enum RunState {
    WORKING(1, "正在运行"),
    PAUSE(0, "暂停中"),
    ERROR(-1, "运行错误"),
    STOPPED(2, "停止"),
    COMPLETE(3, "已完成"),
    ;

    private Integer code;
    private String name;

    RunState(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return code.toString();
    }
}
