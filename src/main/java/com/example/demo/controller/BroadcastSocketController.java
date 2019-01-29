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


    //跳转到topic页面
    @RequestMapping("/topic")
    public String topic() {
        return "topic";
    }


    @MessageMapping("/welcomeTopic")//url请求映射进来
    @SendTo("/topic/getResponse")//向订阅@SendTo 中的路径的浏览器，发送消息。
    public ResponseMessageModel getResponse(RequestMessageModel message) {
        System.out.println("发送信息-----------------------/welcome -----to-------/topic/getResponse" + message.getMessage());
        return new ResponseMessageModel("Welcome, " + message.getMessage() + "!");
    }
}
