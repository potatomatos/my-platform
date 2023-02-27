package cn.cxnxs.telegram.config;

import org.drinkless.tdlib.TdApi;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * <p>开发者信息配置</p>
 *
 * @author mengjinyuan
 * @date 2021-09-26 21:50
 **/
@Component
@ConfigurationProperties(prefix = "telegram.client")
public class TdClientConfigProperties {

    /**
     * 客户端信息
     */
    private Properties config;

    /**
     * 客户端代理信息
     */
    private Proxy proxy;

    public static class Proxy{
        private Class<? extends TdApi.ProxyType> type;

        private Properties config;

        private String server;

        private Integer port;

        private Boolean enable;

        public Properties getConfig() {
            return config;
        }

        public void setConfig(Properties config) {
            this.config = config;
        }

        public Class<? extends TdApi.ProxyType> getType() {
            return type;
        }

        public void setType(Class<? extends TdApi.ProxyType> type) {
            this.type = type;
        }

        public String getServer() {
            return server;
        }

        public void setServer(String server) {
            this.server = server;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(Integer port) {
            this.port = port;
        }

        public Boolean getEnable() {
            return enable;
        }

        public void setEnable(Boolean enable) {
            this.enable = enable;
        }

        @Override
        public String toString() {
            return "Proxy{" +
                    "type=" + type +
                    ", cn.cxnxs.telegram.config=" + config +
                    ", server='" + server + '\'' +
                    ", port=" + port +
                    ", enable=" + enable +
                    '}';
        }
    }

    public Properties getConfig() {
        return config;
    }

    public void setConfig(Properties config) {
        this.config = config;
    }

    public Proxy getProxy() {
        return proxy;
    }

    public void setProxy(Proxy proxy) {
        this.proxy = proxy;
    }

    @Override
    public String toString() {
        return "ClientConfig{" +
                "cn.cxnxs.telegram.config=" + config +
                ", proxy=" + proxy +
                '}';
    }
}
