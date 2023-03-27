package org.natija.mq;

import org.natija.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = {"${mq.queue.name}"})
    public void consume(String model) {
        LOGGER.info("Received message ->" + model);
    }

}
