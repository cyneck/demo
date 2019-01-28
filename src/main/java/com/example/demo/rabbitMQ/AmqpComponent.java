package com.example.demo.rabbitMQ;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Package : com.example.demo.rabbitMQ
 * Description : TODO
 * Create on : 2019/1/28 15:20 星期一
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/

@Component
public class AmqpComponent {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * 发送消息，生产者
     *
     * @param msg
     */
    public void send(String msg) {
        this.amqpTemplate.convertAndSend("eric.queue", msg);
    }

    /**
     * 接收消息,消费者
     *
     * @param text
     */
    @RabbitListener(queues = "eric.queue")//监听指定队列的消息
    @RabbitHandler
    public String receiveQueue(String text) {
        System.out.println("接受到：" + text);
        return text;
    }
}
