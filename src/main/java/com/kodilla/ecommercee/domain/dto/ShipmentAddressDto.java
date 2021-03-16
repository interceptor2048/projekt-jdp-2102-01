package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentAddressDto {
    private Order order;
    private String address;
}
