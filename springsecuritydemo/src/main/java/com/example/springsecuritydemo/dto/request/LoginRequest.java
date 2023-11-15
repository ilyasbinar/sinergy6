package com.example.springsecuritydemo.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginRequest {
    private String username;
    private String password;
}
/**
 * {
 *     "username": "ilyas",
 *     "passwword": "123456
 * }
 */