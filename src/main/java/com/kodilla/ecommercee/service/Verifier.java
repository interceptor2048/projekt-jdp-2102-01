package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.controller.exceptions.OrderNotFoundException;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Verifier {

    @Autowired
    OrderDbService orderDbService;
    @Autowired
    OrderItemDbService orderItemDbService;

    public boolean isOrderFinalized(long orderId) throws OrderNotFoundException {
        Order order = orderDbService.getOrder(orderId).orElseThrow(OrderNotFoundException::new);
        if(order.isVerified() && order.isPaid() && order.isSent()) { return true; }
        return false;
    }

    public void verifyOrder(Long orderId) {
        List<OrderItem> orderItemList = orderItemDbService.getOrderItemsByOrderId(orderId);
    }
}
