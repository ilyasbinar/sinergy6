package com.example.binarchat.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics="binarchat", groupId = "binar-group-id")
    public void sendMessage(String topic, String message){
        System.out.println("Pesan diterima di topic"+ topic+": "+message);
    }
}
