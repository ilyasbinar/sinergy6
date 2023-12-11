package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.model.User;

public interface UserService {
    void createUserPostLogin(String name, String email);

    User getByUsername(String username);
}
