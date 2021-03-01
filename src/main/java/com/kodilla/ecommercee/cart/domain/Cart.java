package com.kodilla.ecommercee.cart.domain;

import com.kodilla.ecommercee.user.domain.User;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "carts")
public class Cart {
    @Id
    private Long id;

    @ManyToOne
    private User user;
}
