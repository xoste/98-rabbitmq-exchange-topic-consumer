package com.xoste.rabbitmqexchangetopicconsumer.consumer;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * info消息消费者
 * @author Leon
 */
@Component
@RabbitListener(bindings = @QueueBinding(
        exchange = @Exchange(value = "${rabbitmq.config.exchange}", type = ExchangeTypes.TOPIC),
        key = "*.log.*",
        value = @Queue(value = "${rabbitmq.config.queue.log}", autoDelete = "true")
))
public class LogConsumer {

    @RabbitHandler
    public void logConsumer(String msg) {
        System.out.println("log......consumer:" + msg);
    }
}
