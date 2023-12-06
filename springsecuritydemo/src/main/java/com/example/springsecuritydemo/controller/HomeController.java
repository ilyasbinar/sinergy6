package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.dto.response.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello Binar";
    }

    @GetMapping("/public")
    public ResponseEntity<?> publicResource(){
        return ResponseHandler.generateResponse("success",
                "Anda berhasil mengakses halaman public",
                null, HttpStatus.OK);
    }

    @GetMapping("/secured")
    public ResponseEntity<?> secured(){
        return ResponseHandler.generateResponse("success",
                "Anda berhasil mengakses halaman yang perlu otentikasi",
                null, HttpStatus.OK);
    }
}
