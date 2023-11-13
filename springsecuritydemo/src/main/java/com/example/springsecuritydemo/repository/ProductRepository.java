package com.example.springsecuritydemo.repository;

import com.example.springsecuritydemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByActive(boolean active);
}
