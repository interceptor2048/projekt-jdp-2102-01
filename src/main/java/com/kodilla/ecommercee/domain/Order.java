package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Order {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(
            targetEntity = OrderItems.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<OrderItems> orderItems= new ArrayList<>();

    @Column(name = "is_payment_confirmed")
    private boolean paid;

    @Column(name = "is_verified")
    private boolean verified;

    @Column(name = "is_sent")
    private boolean sent;

    public Order(@NotNull Long id, User user) {
        this.id = id;
        this.user = user;
    }

    public Order(@NotNull Long id, User user, boolean paid, boolean verified, boolean sent) {
        this.id = id;
        this.user = user;
        this.paid = paid;
        this.verified = verified;
        this.sent = sent;
    }
}
