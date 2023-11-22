package com.example.demooauth2binar.service;

import com.example.demooauth2binar.model.User;

public interface UserService {
    void createUserPostLogin(String name, String email);

    User getByUsername(String username);
}
