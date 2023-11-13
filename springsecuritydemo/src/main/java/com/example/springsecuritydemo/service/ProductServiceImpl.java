package com.example.springsecuritydemo.service;


import com.example.springsecuritydemo.model.Product;
import com.example.springsecuritydemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getActive() {
        return productRepository.findAllByActive(true);
    }

    @Override
    public Product getById(long id) {
        return productRepository.findById(id).get();
    }
}
