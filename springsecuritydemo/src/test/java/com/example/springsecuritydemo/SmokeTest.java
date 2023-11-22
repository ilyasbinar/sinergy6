package com.example.springsecuritydemo;

import com.example.springsecuritydemo.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {
    @Autowired
    private ProductController controller;

    @Test
    void contextLoads(){
        assertThat(controller).isNull();
    }
}
