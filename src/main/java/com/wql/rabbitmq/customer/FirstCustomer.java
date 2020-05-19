package com.wql.rabbitmq.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "FIRST_QUEUE")
public class FirstCustomer {

    @RabbitHandler
    public void process(String msg){
        System.out.println("first queue received msg:" + msg);
    }
}

