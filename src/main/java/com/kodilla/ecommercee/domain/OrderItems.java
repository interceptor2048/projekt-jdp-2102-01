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
public class OrderItems {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    public OrderItems(Product product, Order order) {
        this.product = product;
        this.order = order;
    }
}