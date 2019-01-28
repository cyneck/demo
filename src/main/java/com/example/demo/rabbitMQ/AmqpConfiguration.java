package com.example.demo.rabbitMQ;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Package : com.example.demo.rabbitMQ
 * Description : amqp队列配置
 * Create on : 2019/1/28 15:16 星期一
 *
 * @author Xingli.Li
 * @version v1.0.0
 * 修改历史:
 * 修改人 | 修改日期 | 修改描述
 * -------------------------------------------
 **/

@Configuration
public class AmqpConfiguration {
    @Bean
    public Queue queue() {
        return new Queue("eric.queue");//新建一个消息队列
    }
}
