package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orderItems")
public class OrderItem {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderId")
    private Order order;

    public OrderItem(Product product, Order order) {
        this.product = product;
        this.order = order;
    }
}