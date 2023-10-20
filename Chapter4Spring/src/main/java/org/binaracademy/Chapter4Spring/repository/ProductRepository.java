package org.binaracademy.Chapter4Spring.repository;

import org.binaracademy.Chapter4Spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

    List<Product> findAllByPriceGreaterThan(long price);
}
