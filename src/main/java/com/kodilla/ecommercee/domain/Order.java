package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
            targetEntity = OrderItem.class,
            mappedBy = "order",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<OrderItem> orderItems;

    @Column(name = "is_payment_confirmed")
    private boolean paid = false;

    @Column(name = "is_verified")
    private boolean verified = false;

    @Column(name = "is_sent")
    private boolean sent = false;

    @Column(name = "Shipment_to")
    @NotNull
    private String shipmentAddress;

    public Order(User user, List<OrderItem> orderItems) {
        this.user = user;
        this.orderItems = orderItems;
    }

    public Order(@NotNull Long id, User user, boolean paid, boolean verified, boolean sent) {
        this.id = id;
        this.user = user;
        this.paid = paid;
        this.verified = verified;
        this.sent = sent;
    }
}
