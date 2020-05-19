package com.wql.rabbitmq.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "THIRD_QUEUE")
public class ThirdCustomer {

    @RabbitHandler
    public void process(String msg){
        System.out.println("third queue received msg:" + msg);
    }
}

