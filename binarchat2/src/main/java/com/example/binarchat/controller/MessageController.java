package com.example.binarchat.controller;

import com.example.binarchat.kafka.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    private final MessageProducer messageProducer;

    public MessageController(MessageProducer messageProducer) {
        this.messageProducer = messageProducer;
    }

    @PostMapping("send")
    public String sendMessge(@RequestParam("message") String message){
        messageProducer.sendMessage("binarchat", message);
        return "Pesan telah terkirim";
    }
}
