package com.damian.springbootactivemq.config;

import jakarta.jms.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.util.ErrorHandler;

@Configuration
@EnableJms
public class JMSConfig {
    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory(ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory = new DefaultJmsListenerContainerFactory();
        defaultJmsListenerContainerFactory.setConnectionFactory(connectionFactory);
        //Concurrency is the number of consumers that will be created to process the messages
        defaultJmsListenerContainerFactory.setConcurrency("5-10");
        //ErrorHandler is used to handle the errors that occur during the processing of the messages
        defaultJmsListenerContainerFactory.setErrorHandler(new JMSErrorHandler());
        return defaultJmsListenerContainerFactory;
    }
    public static class JMSErrorHandler implements ErrorHandler {
        @Override
        public void handleError(Throwable t) {
            System.err.println("An error has occurred in the transaction : "+t.getLocalizedMessage());
        }
    }
}
