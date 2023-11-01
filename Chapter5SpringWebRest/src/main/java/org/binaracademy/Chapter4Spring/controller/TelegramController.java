package org.binaracademy.Chapter4Spring.controller;

import org.binaracademy.Chapter4Spring.service.JokeService;
import org.binaracademy.Chapter4Spring.service.TelegramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/telegram")
public class TelegramController {
    @Autowired
    JokeService jokeService;

    @Autowired
    TelegramService telegramService;

    @GetMapping("send/{chatId}")
    public String sendMessage(@PathVariable String chatId){
        // Get the joke from https://v2.jokeapi.dev/joke/Any
        String theJoke = jokeService.getJoke();

        // Send the joke via telegram
        https://api.telegram.org/bot6659405691:AAHgjF6uDEAt02BJziBRC4afnoBEt7MZppQ/getUpdates
        //token: 6659405691:AAHgjF6uDEAt02BJziBRC4afnoBEt7MZppQ
        //chatid: 936703837
        telegramService.send(chatId, theJoke);

        return theJoke;
    }

    @GetMapping("sendgempa")
    public String sendInfoGempa(){
//        https://data.bmkg.go.id/DataMKG/TEWS/autogempa.json
        String infoGempa="";

        //kirim info gempa ke telegram

        return infoGempa;
    }
}
