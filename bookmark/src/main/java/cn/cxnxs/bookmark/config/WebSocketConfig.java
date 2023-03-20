package cn.cxnxs.bookmark.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * <p>WebSocket配置类</p>
 *
 * @author mengjinyuan
 * @date 2022-03-30 17:38
 **/
@Configuration
public class WebSocketConfig {

    /**
     * 这个bean会自动注册使用了@ServerEndpoint注解声明的Websocket endpoint。
     * 要注意，如果使用独立的servlet容器，而不是直接使用springboot的内置容器，
     * 就不要注入ServerEndpointExporter，因为它将由容器自己提供和管理
     *
     * 当使用这个类时，通过在Spring配置中声明它，
     * 应该可以关闭Servlet容器对WebSocket端点的扫描
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
