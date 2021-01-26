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
        key = "*.log.error",
        value = @Queue(value = "${rabbitmq.config.queue.error}", autoDelete = "true")
))
public class ErrorConsumer {

    @RabbitHandler
    public void errorConsumer(String msg) {
        System.out.println("error......consumer:" + msg);
    }
}
