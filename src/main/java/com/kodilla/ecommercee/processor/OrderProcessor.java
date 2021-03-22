package com.kodilla.ecommercee.processor;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.repository.UserRepository;

import java.util.List;

public class OrderProcessor implements Observable {

    private List<User> users;
    UserRepository userRepository;

    private Order order;


    public OrderProcessor(Order order) {
        this.order = order;

    }

    @Override
    public void notifyUsers() {
        if (order.isVerified()) {
            order.setPaid(true);

            System.out.println("Order status changed into: " + order.isVerified() + order.isPaid());
        } else {
            order.setPaid(false);
            System.out.println("Order status: " + order.isVerified() + order.isPaid());
        }

    }

    @Override
    public void removeUsers(User user) {
        users.remove(user);
    }
}