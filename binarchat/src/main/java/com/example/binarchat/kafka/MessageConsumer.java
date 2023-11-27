package com.example.binarchat.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @KafkaListener(topics="binarchat", groupId = "binar-group-id")
    public void listen(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic){
        System.out.println("Pesan diterima di topic"+ topic+": "+message);
    }
}
