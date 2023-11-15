package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.dto.request.LoginRequest;
import com.example.springsecuritydemo.dto.response.JwtResponse;
import com.example.springsecuritydemo.dto.response.ResponseHandler;
import com.example.springsecuritydemo.security.jwt.JwtUtils;
import com.example.springsecuritydemo.security.service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody LoginRequest loginRequest){
        Authentication authentication = authenticationManager
                .authenticate( new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        JwtResponse jwtResponse = new JwtResponse(jwt, userDetails.getUsername(), roles);
        return ResponseHandler.generateResponse("success", jwtResponse, null, HttpStatus.OK);
    }
}
