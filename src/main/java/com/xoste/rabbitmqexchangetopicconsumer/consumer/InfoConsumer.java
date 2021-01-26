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
        key = "*.log.info",
        value = @Queue(value = "${rabbitmq.config.queue.info}", autoDelete = "true")
))
public class InfoConsumer {

    @RabbitHandler
    public void infoConsumer(String msg) {
        System.out.println("info......consumer:" + msg);
    }
}
