package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.dto.OrderDto;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public Order mapToOrder(final OrderDto orderDto) {
        return new Order();

    }

    public OrderDto mapToOrderDto(final Order order) {
        return new OrderDto();

    }

    public List<Order> orderDtoListToOrder(List<OrderDto> orderDtoList) {
        return new ArrayList<>();
    }

    public List<OrderDto> orderListToOrderTo(List<Order> orderList) {
        return new ArrayList<>();
    }
}
