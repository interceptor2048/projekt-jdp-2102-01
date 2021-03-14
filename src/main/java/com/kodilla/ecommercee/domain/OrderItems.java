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

    private Long id;

    @ManyToOne
    @JoinColumn(name = "productId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;
}