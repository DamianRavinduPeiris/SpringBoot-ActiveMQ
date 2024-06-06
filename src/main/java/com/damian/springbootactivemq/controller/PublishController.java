package com.damian.springbootactivemq.controller;

import com.damian.springbootactivemq.model.SystemMessage;
import com.damian.springbootactivemq.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publishMessage")
public class PublishController {
    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping(path = "/publish")
    public ResponseEntity<Response> publishMessage(@RequestBody SystemMessage systemMessage) {
        try {
            jmsTemplate.convertAndSend("first-queue", systemMessage);
        } catch (Exception e) {
            return ResponseEntity.ok(new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An error occurred while publishing message!", null));
        }
        return ResponseEntity.ok(new Response(HttpStatus.OK.value(), "Message published successfully!", null));
    }
}
