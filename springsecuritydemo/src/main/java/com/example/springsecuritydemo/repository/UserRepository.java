package com.example.springsecuritydemo.repository;

import com.example.springsecuritydemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
