package com.kodilla.ecommercee.processor;

import com.kodilla.ecommercee.controller.OrderController;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.mapper.OrderMapper;
import com.kodilla.ecommercee.repository.UserRepository;
import com.kodilla.ecommercee.service.information.EmailSender;

import java.util.List;

public class OrderProcessor implements Observable {

    private List<User> users;
    UserRepository userRepository;

    //private Order order;

    private OrderController controller;

    private OrderMapper mapper;

    private EmailSender emailSender;

    /*public OrderProcessor(Order order) {
        this.order = order;

    }*/

    public void verifyOrder (Order order) {
        order.setVerified(true);
        controller.updateOrder(mapper.mapToOrderDto(order));
        emailSender.notifyOrderVerified(order);
    }

    public void payOrder (Order order) {
        order.setPaid(true);
        controller.updateOrder(mapper.mapToOrderDto(order));
        emailSender.notifyOrderPaid(order);
    }

    public void sendOrder (Order order) {
        order.setSent(true);
        controller.updateOrder(mapper.mapToOrderDto(order));
        emailSender.notifyOrderSent(order);
    }

    @Override
    public void notifyUsers() {
       /* if (order.isVerified()) {
            order.setPaid(true);

            System.out.println("Order status changed into: " + order.isVerified() + order.isPaid());
        } else {
            order.setPaid(false);
            System.out.println("Order status: " + order.isVerified() + order.isPaid());
        }*/

    }

    @Override
    public void removeUsers(User user) {
        users.remove(user);
    }
}