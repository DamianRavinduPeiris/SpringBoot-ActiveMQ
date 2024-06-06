package com.damian.springbootactivemq.consumer;

import com.damian.springbootactivemq.model.SystemMessage;
import org.slf4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(MessageConsumer.class);


    @JmsListener(destination = "first-queue")
    public void receiveMessage(SystemMessage systemMessage) {
        LOGGER.info("Source : " + systemMessage.getSource());
        LOGGER.info("Message : " + systemMessage.getMessage());

    }
}
