package com.wql.rabbitmq.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "FOURTH_QUEUE")
public class ForthCustomer {

    @RabbitHandler
    public void process(String msg){
        System.out.println("forth queue received msg:" + msg);
    }
}

