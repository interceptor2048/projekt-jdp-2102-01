package com.kodilla.ecommercee.domain.dto;

import com.kodilla.ecommercee.domain.OrderItem;
import com.kodilla.ecommercee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private User user;
    private List<OrderItem> orderItemList;
    private boolean paid, verified, sent;
}
