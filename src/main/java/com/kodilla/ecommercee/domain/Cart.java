package com.kodilla.ecommercee.domain;

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
