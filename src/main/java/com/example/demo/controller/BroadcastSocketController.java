package com.example.demo.controller;

import com.example.demo.model.RequestMessageModel;
import com.example.demo.model.ResponseMessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Package : com.example.demo.controller
 * Description : 广播信息，凡是订阅了/topic/getResponse路径的信息都能接受到
 * Create on : 2018/10/30 20:06 星期二
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
@Controller
public class BroadcastSocketController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;


    @RequestMapping("/topic")
    public String topic() {
        return "topic";
    }


    @MessageMapping("/welcomeTopic")//浏览器发送请求通过@messageMapping 映射/welcome 这个地址。
    @SendTo("/topic/getResponse")//服务器端有消息时,会订阅@SendTo 中的路径的浏览器发送消息。
    public ResponseMessageModel say(RequestMessageModel message) throws Exception {
        System.out.println("发送信息-----------------------" + message.getMessage());
        return new ResponseMessageModel("Welcome, " + message.getMessage() + "!");
    }
}
