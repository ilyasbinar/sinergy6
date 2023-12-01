package com.example.secondservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class ConsumerController {

    @GetMapping("/message")
    public String getMessage(){
        return "Hello from Consumer";
    }
}
