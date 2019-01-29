package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * Package : com.example.demo.config
 * Description : websocket配置
 * Create on : 2018/10/30 19:55 星期二
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
@Configuration
/*注解表示开启使用STOMP协议来传输基于代理的消息，Broker就是代理的意思。
控制器支持使用@MessageMapping,就像使用@RequestMapping一样*/
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    /***
     * 注册 Stomp的端点
     * addEndpoint：添加STOMP协议的访问端点。提供WebSocket或SockJS客户端访问的地址，客户端打开双通道时需要的url
     * setAllowedOrigins：允许所有的域名跨域访问
     * withSockJS：使用SockJS协议
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpoint")
                .withSockJS();
        // withSockJS()表示支持socktJS访问，在浏览器中使用
        registry.addEndpoint("/websocket")
                .setAllowedOrigins("*")//添加允许跨域访问
                .withSockJS();
    }

    /**
     * 配置消息代理
     * 启动Broker，消息的发送的地址符合配置的前缀来的消息才发送到这个broker
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //服务器发送给客户端的前缀，配置一个/topic广播消息代理和“/app”,"/user"一对一消息代理
        registry.enableSimpleBroker("/topic", "/app", "/user");
        //全局使用的订阅前缀,应用请求前缀,比如@MessageMapping("/hello-socket")，浏览器端发送消息地址就是app/hello-socket;
        registry.setApplicationDestinationPrefixes("/app");
        //点对点使用的订阅前缀（客户端订阅路径上会体现出来），不设置的话，默认也是/user/
        registry.setUserDestinationPrefix("/user");
    }
}
