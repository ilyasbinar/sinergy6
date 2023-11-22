package com.example.springsecuritydemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class AutoConfigurerMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void productActiveShouldReturnProducts() throws Exception {
        String responseJson = "{\"data\":[{\"id\":1,\"name\":\"Kipas Angin\",\"price\":200000,\"active\":true},{\"id\":2,\"name\":\"Mouse\",\"price\":100000,\"active\":true}],\"status\":\"success\"}";
        mockMvc.perform(get("/api/product/active"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(responseJson));
    }
}