package com.example.springsecuritydemo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebEnvirontmentTest {
    //apakah sebuah endpoint dapat diakses.

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void productActiveShouldReturnProducts(){
        assertThat(restTemplate.getForObject("http://localhost:"+port+"/api/product/active", String.class)
                .contains("success"));

    }
}
