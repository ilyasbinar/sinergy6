package com.example.springsecuritydemo.controller;

import com.example.springsecuritydemo.model.Product;
import com.example.springsecuritydemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    ProductService productService;

    //1 endpoint public: daftar product yang sedang dijual.
    @GetMapping("/active")
    public ResponseEntity<List<Product>> activeProduct(){
        List<Product> activeProductList = productService.getActive();
        return new ResponseEntity<>(activeProductList, HttpStatus.OK);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Product> activeProduct(@PathVariable long id){
        Product product = productService.getById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }


    //1 endpoint authorization: user untuku beli

}
