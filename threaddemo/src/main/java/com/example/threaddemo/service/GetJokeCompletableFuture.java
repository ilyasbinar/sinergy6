package com.example.threaddemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class GetJokeCompletableFuture {

    public CompletableFuture<String> getJokeAsync(){
        return CompletableFuture.supplyAsync(()-> {
            String response;
            try {
                System.out.println("Fetching data joke in jokeapi");
                TimeUnit.SECONDS.sleep(5);
                response = "ini adalah joke";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return response;
        });
    }

    public CompletableFuture<String> getEmailUser(){
        return CompletableFuture.supplyAsync(()-> {
            String email;
            try {
                System.out.println("Fetching data email in user microservice");
                TimeUnit.SECONDS.sleep(5);
                email = "ilyas@lua.co.id";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return email;
        });
    }

    public CompletableFuture<Boolean> sendEmailAsync(String email, String joke){
        return CompletableFuture.supplyAsync(()-> {
            boolean success =false;
            try {
                System.out.println("Kirim joke "+joke+" ke "+email);
                TimeUnit.SECONDS.sleep(5);
                success = true;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            return success;
        });
    }
}
