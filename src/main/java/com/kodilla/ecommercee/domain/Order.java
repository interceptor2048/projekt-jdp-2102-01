package com.kodilla.ecommercee.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "orders")
public class Order {
    @Id
    private Long id;

    @ManyToOne
    private User user;
}
