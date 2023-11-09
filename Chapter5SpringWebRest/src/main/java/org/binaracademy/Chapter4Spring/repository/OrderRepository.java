package org.binaracademy.Chapter4Spring.repository;

import org.binaracademy.Chapter4Spring.model.Merchant;
import org.binaracademy.Chapter4Spring.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    @Query(value = "select * from order where id=?1", nativeQuery = true)
    List<Order> getOrderByMerchant(UUID merchantId);
}
