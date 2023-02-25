package cn.cxnxs.telegram.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2021-09-27 00:01
 **/
@Component
@ConfigurationProperties(prefix = "telegram")
public class TgConfig {
    private String tdlib;

    private Boolean disableLog;

    public Boolean getDisableLog() {
        return disableLog;
    }

    public void setDisableLog(Boolean disableLog) {
        this.disableLog = disableLog;
    }

    public String getTdlib() {
        return tdlib;
    }

    public void setTdlib(String tdlib) {
        this.tdlib = tdlib;
    }

    @Override
    public String toString() {
        return "TgConfig{" +
                "cn.cxnxs.telegram.tdlib='" + tdlib + '\'' +
                ", disableLog=" + disableLog +
                '}';
    }
}
