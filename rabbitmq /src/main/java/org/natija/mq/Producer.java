package org.natija.mq;


import org.natija.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class Producer {
    @Value("${mq.exchange}")
    private String exchange;

    @Value("${mq.routing-key}")
    private String key;

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(Model model) {
        rabbitTemplate.convertAndSend(exchange, key, model.toString());
        LOGGER.info(String.format("Message sent %s", model));
    }

    public void sendJsonMessage(Object object) {
        LOGGER.info(String.format("Json message sent -> %s", object.toString()));
        rabbitTemplate.convertAndSend(exchange, "json_key", object);
    }

}
