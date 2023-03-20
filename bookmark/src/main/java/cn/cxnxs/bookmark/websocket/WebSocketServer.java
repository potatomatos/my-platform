package cn.cxnxs.bookmark.websocket;

import cn.cxnxs.bookmark.vo.response.WebsocketVo;
import cn.cxnxs.common.core.entity.response.Result;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-03-30 17:44
 **/
@Slf4j
@ServerEndpoint("/websocket/{token}")
@Component
public class WebSocketServer {
    /**
     * concurrent包的线程安全set，用来存放每个客户端对应的MyWebSocket
     */
    private static final ConcurrentHashMap<String, WebSocketServer> WEB_SOCKET_MAP = new ConcurrentHashMap<>();
    /**
     * 与某个客户端的连接会话，通过session传递消息
     *
     */
    private Session session;

    private String token;

    /**
     * 此处是解决无法注入的关键
     */
    private static ApplicationContext applicationContext;
    public static void setApplicationContext(ApplicationContext applicationContext) {
        WebSocketServer.applicationContext = applicationContext;
    }

    /**
     * 建立连接成功的回调
     * @param session
     */
    @OnOpen
    public void open(Session session, @PathParam( "token") String token) throws IOException {
        this.session = session;
        this.token=token;
        WEB_SOCKET_MAP.put(token,this);
        log.info("连接成功");
        sendMessage(Result.success("连接成功"));
    }

    /**
     * 连接关闭的回调
     */
    @OnClose
    public void close(){
        WEB_SOCKET_MAP.remove(this.token);
        log.info("连接关闭");
    }

    /**
     * 发生错误的回调
     * @param session
     * @param err
     */
    @OnError
    public void error(Session session, Throwable err){
        this.session = session;
        log.error("连接错误",err);
    }

    /**
     * 收到客户端消息后的回调
     * @param session
     * @param message
     */
    @OnMessage
    public void message(Session session, String message) throws IOException {
        this.session = session;
        //心跳检测
        if ("ping".equals(message)){
            sendMessage(Result.success("心跳正常"));
        }else{
            log.info("收到信息: {}" , message);
        }
    }

    /**
     * 服务器主动发消息
     * @param result
     * @throws IOException
     */
    private  <T> void sendMessage(Result<T> result) throws IOException {
        this.session.getBasicRemote().sendText(JSON.toJSONString(result));
    }

    /**
     * 外部调用发送消息接口
     * @param result
     * @param <T>
     * @throws IOException
     */
    public static void sendInfo(Result<WebsocketVo> result) throws IOException {
        WebsocketVo data = result.getData();
        WebSocketServer webSocketServer = WEB_SOCKET_MAP.get(data.getToUser());
        if (webSocketServer!=null){
            webSocketServer.sendMessage(result);
        }else{
            log.error("客户端不存在");
        }
    }
}
