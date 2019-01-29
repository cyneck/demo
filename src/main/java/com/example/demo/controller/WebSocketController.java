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

    //跳转到index页面
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    //跳转到index2页面
    @RequestMapping("/index2")
    public String index2() {
        return "index2";
    }

    //发送到指定的用户
    @ResponseBody
    @RequestMapping("/send/{userid}")
    public String send(@PathVariable("userid") String userid) {
        this.messagingTemplate.convertAndSendToUser(userid, "/message", "发发发");
        return "发送成功！";
    }

    //浏览器端，发送到后端的映射路径
    @MessageMapping("/toUser")
    public ResponseMessageModel toUser(RequestMessageModel msg) {
        System.out.println("----------------/toUser" + msg.getMessage());

        //即@SendTo()，浏览器端，订阅路径，此处带为点对点层级的
        this.messagingTemplate.convertAndSendToUser(msg.getToUserId(), "/message", msg.getMessage());

//        this.messagingTemplate.convertAndSendToUser(msg.getUserid(), "/message", msg.getMessage());

        return new ResponseMessageModel(msg.getMessage());
    }
}
