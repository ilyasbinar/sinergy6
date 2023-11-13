package com.example.springsecuritydemo.repository;

import com.example.springsecuritydemo.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
