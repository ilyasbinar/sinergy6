package org.binaracademy.Chapter4Spring.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
class OrderProductKey implements Serializable {

    @Column(name = "order_id")
    Long orderId;

    @Column(name = "product_id")
    Long productId;

    // standard constructors, getters, and setters
    // hashcode and equals implementation
}