package com.example.apigateway.models;

import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class OrderService {
    public String order(Principal principal){
        //logic order
        //User user = userRepository.findByUsername(principal.getName());
        User user  = (User) jdbcTemplate.url("http://localhost:8083/consumer/username/"+principal.getName());

        Order order = new Order();
        order.setUser(user);
        return "";
    }
}
