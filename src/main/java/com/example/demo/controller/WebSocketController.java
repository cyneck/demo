package com.example.demo.controller;

import com.example.demo.model.RequestMessageModel;
import com.example.demo.model.ResponseMessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Package : com.example.demo.controller
 * Description : TODO @类注释说明写在此处@
 * Create on : 2018/10/30 20:04 星期二
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/
@Controller
public class WebSocketController {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/index2")
    public String index2() {
        return "index2";
    }

    @ResponseBody
    @RequestMapping("/test/{userid}")
    public String test(@PathVariable("userid") String userid, RequestMessageModel msg) {
        this.messagingTemplate.convertAndSendToUser(userid, "/message", msg.getMessage());//" /user/123/message "
        return "发送成功！";
    }

    //  "/app/welcome
    @MessageMapping("/welcome")
    public ResponseMessageModel toTopic(RequestMessageModel msg) throws Exception {
        System.out.println("======================" + msg.getMessage());
        this.messagingTemplate.convertAndSend("/api/v1/socket/send", msg.getMessage());

        this.messagingTemplate.convertAndSend("/topic/send", msg.getMessage());

        return new ResponseMessageModel("欢迎使用webScoket：" + msg.getMessage());
    }

    @MessageMapping("/message")
    public ResponseMessageModel toUser(RequestMessageModel msg) {
        System.out.println("----------------" + msg.getMessage());

        this.messagingTemplate.convertAndSendToUser(msg.getUserid().toString(), "/message", msg.getMessage());
        this.messagingTemplate.convertAndSendToUser(msg.getToUserId().toString(), "/message", msg.getMessage());

        return new ResponseMessageModel("欢迎使用webScoket：" + msg.getMessage());
    }
}
