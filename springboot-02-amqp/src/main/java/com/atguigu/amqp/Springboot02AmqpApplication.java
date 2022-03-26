package com.atguigu.amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置
 *
 * 1、RabbitAutoConfiguration；
 * 2、自动配置了连接工厂（ConnectionFactory）；
 * 3、封装了rabbit的所有配置 RabbitProperties；
 * 4、RabbitTemplate：给rabbit发送和接收消息；
 * 5、AmqpAdmin：RabbitMQ系统管理组件；
 *      AmqpAdmin: 创建和删除Queue、Exchange、Binding
 * 6、@EnableRabbit + @RabbitListener(queues = {"atguigu.news"}) 监听消息队列的内容
 */
@EnableRabbit// 开启基于注解的rabbutMQ模式
@SpringBootApplication
public class Springboot02AmqpApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02AmqpApplication.class, args);
    }

}
