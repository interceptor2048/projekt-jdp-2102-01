package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ShipmentAddress {
    @OneToOne(
            targetEntity = Order.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "ID"
    )
    private Order order;


    private String address;
}
