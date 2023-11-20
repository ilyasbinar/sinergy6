package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.dto.response.ResponseHandler;
import com.example.springsecuritydemo.model.Product;
import com.example.springsecuritydemo.model.User;
import com.example.springsecuritydemo.repository.UserRepository;
import com.example.springsecuritydemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    //1 endpoint public: daftar product yang sedang dijual.
    @GetMapping("/active")
    public ResponseEntity<?> activeProduct(){
        System.out.println(passwordEncoder.encode("abc123456"));
        List<Product> activeProductList = productService.getActive();
        return ResponseHandler.generateResponse("success", activeProductList, null, HttpStatus.OK);
    }

    @GetMapping("/add")
    @PreAuthorize("hasRole('MERCHANT')")
    public ResponseEntity<?> addProduct(){
        System.out.println(passwordEncoder.encode("abc123456"));
        List<Product> activeProductList = productService.getActive();
        return ResponseHandler.generateResponse("success", activeProductList, null, HttpStatus.OK);
    }


    //1 endpoint authorization: user untuku beli
    @GetMapping("/order/{id}")
    @PreAuthorize("hasRole('BUYER')")
    public ResponseEntity<?> activeProduct(@PathVariable long id,
                                                 Authentication authentication, Principal principal){
        Product product = productService.getById(id);
        return ResponseHandler.generateResponse("success", product, null, HttpStatus.OK);
    }

    @GetMapping("/invoice/{id}")
    @Secured({"BUYER", "SELLER"})
    public ResponseEntity<?> invoice(@PathVariable long id, Principal principal){
        User user = userRepository.findByUsername(principal.getName()).get();

        //cek apakah user boleh lihat invoice
//        if(order.getUserId != user.getId()){
//            throw new RuntimeException();
//        }

        Product product = productService.getById(id);
        return ResponseHandler.generateResponse("success", product, null, HttpStatus.OK);
    }

}
