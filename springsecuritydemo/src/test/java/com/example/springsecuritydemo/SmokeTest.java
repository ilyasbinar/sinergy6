package com.example.springsecuritydemo;

import com.example.springsecuritydemo.controller.ProductController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

    @Autowired
    private ProductController productController;

    @Test
    void contextLoad(){
        Assertions.assertThat(productController).isNotNull();
    }
}
