package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getActive();

    Product getById(long id);
}
