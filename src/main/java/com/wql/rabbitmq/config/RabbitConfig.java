package com.wql.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    /**
     * direct交换机
     * @return
     */
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("DIRECT_EXCHANGE");
    }

    /**
     * topic交换机
     */
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("TOPIC_EXCHANGE");
    }

    /**
     * 广播交换机
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("FANOUT_EXCHANGE");
    }

    /**
     * 创建第一个队列
     * @return
     */
    @Bean
    public Queue firstQueue(){
        return new Queue("FIRST_QUEUE");
    }

    /**
     * 创建第二个队列
     * @return
     */
    @Bean
    public Queue secondQueue(){
        return new Queue("SECOND_QUEUE");
    }

    @Bean
    public Queue thirdQueue(){
        return new Queue("THIRD_QUEUE");
    }

    @Bean
    public Queue fourthQueue(){
        return new Queue("FOURTH_QUEUE");
    }

    //创建绑定关系
    @Bean
    public Binding bindFirst(@Qualifier("firstQueue") Queue queue,@Qualifier("directExchange") DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with("gupao.base");
    }

    @Bean
    public Binding bindSecond(@Qualifier("secondQueue") Queue queue,@Qualifier("topicExchange") TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("*.gupao.*");
    }

    @Bean
    public Binding bindThird(@Qualifier("thirdQueue") Queue queue,@Qualifier("fanoutExchange") FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }

    @Bean
    public Binding bindForth(@Qualifier("fourthQueue") Queue queue,@Qualifier("fanoutExchange") FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }


}
