package org.binaracademy.Chapter4Spring.service;

import org.binaracademy.Chapter4Spring.model.dto.telegram.ResponseMessageTelegram;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TelegramService {
    private final String BOT_TOKEN="6659405691:AAHgjF6uDEAt02BJziBRC4afnoBEt7MZppQ";
    public ResponseMessageTelegram send(String chatId, String message) {


        RestTemplate restTemplate = new RestTemplateBuilder().build();
        ResponseMessageTelegram responseMessageTelegram = restTemplate.getForObject("https://api.telegram.org/bot"+BOT_TOKEN+
                "/sendMessage?chat_id="+chatId+"&text={text}", ResponseMessageTelegram.class, message);

        return responseMessageTelegram;
    }
}
