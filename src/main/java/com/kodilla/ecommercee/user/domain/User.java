package com.kodilla.ecommercee.user.domain;

import com.kodilla.ecommercee.cart.domain.Cart;
import com.kodilla.ecommercee.order.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class User{
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "User_id")
    private Long id;

    @NotNull
    @Column(name = "Username")
    private String userName;

    @Column(name = "Status")
    @NotNull
    private Integer status;

    @NotNull
    @Column(name = "userKey")
    private Long userKey;

    @OneToMany(
            targetEntity = Order.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;
}
