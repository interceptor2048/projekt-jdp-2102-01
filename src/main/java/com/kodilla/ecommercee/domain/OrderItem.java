package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orderItems")
public class OrderItem {

    @Id
    @GeneratedValue
    @NotNull
<<<<<<< HEAD:src/main/java/com/kodilla/ecommercee/domain/OrderItem.java
    @Column(name = "id", unique = true)
=======

>>>>>>> d9bdc52c591e5a98c1cb087186c328b29d906d35:src/main/java/com/kodilla/ecommercee/domain/OrderItems.java
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    public OrderItem(Product product, Order order) {
        this.product = product;
        this.order = order;
    }
}