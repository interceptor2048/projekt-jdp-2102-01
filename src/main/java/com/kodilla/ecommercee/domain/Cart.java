package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "carts")
@Entity
public class Cart {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "Cart_id")
    private Long id;

    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "User_id")
    private User user;

    @ManyToMany(
            targetEntity = Product.class,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "Cart_id")
    private List<Product> products;
}
