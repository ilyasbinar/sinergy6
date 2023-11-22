package com.example.springsecuritydemo;

import com.example.springsecuritydemo.controller.ProductController;
import com.example.springsecuritydemo.repository.ProductRepository;
import com.example.springsecuritydemo.repository.UserRepository;
import com.example.springsecuritydemo.security.WebSecurityConfig;
import com.example.springsecuritydemo.security.jwt.AuthEntryPointJwt;
import com.example.springsecuritydemo.security.jwt.JwtUtils;
import com.example.springsecuritydemo.security.service.UserDetailsServiceImpl;
import com.example.springsecuritydemo.service.ProductService;
import com.example.springsecuritydemo.service.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(ProductController.class)
@Import({WebSecurityConfig.class, JwtUtils.class, ProductServiceImpl.class})
public class WebMvcDemoTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ProductRepository productRepository;

    @MockBean
    AuthEntryPointJwt authEntryPointJwt;

    @MockBean
    UserDetailsServiceImpl userDetailsService;

    @MockBean
    UserRepository userRepository;

    @Test
    void productActiveShouldReturnProducts() throws Exception {
        //
        String responseJson = "{\"data\":[{\"id\":1,\"name\":\"Kipas Angin\",\"price\":200000,\"active\":true},{\"id\":2,\"name\":\"Mouse\",\"price\":100000,\"active\":true}],\"status\":\"success\"}";
        mockMvc.perform(get("/api/product/active"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().string(responseJson));
    }
}
