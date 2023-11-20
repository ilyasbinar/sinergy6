package com.example.demooauth2binar.controller;

import com.example.demooauth2binar.dto.ResponseHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/public")
    public ResponseEntity<?> activeProduct(){

        return ResponseHandler.generateResponse("success",
                "Anda berhasil mengakses halaman public",
                null, HttpStatus.OK);
    }

    @GetMapping("/secured")
    public ResponseEntity<?> addProduct(){
        return ResponseHandler.generateResponse("success",
                "Anda berhasil mengakses halaman yang perlu otentikasi",
                null, HttpStatus.OK);
    }
}
