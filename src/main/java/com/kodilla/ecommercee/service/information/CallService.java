package com.kodilla.ecommercee.service.information;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import org.springframework.stereotype.Service;

@Service
public class CallService implements Notificators {
    @Override
    public void notifyOrderCreated(Order order, User user) {
        System.out.println("Calling " + user.getPhoneNumber());
    }

    @Override
    public void notifyOrderVerified(User user, Order order) {
        System.out.println("Calling " + user.getPhoneNumber());
    }

    @Override
    public void notifyOrderPaid(User user, Order order) {
        System.out.println("Calling " + user.getPhoneNumber());
    }

    @Override
    public void notifyOrderSent(User user, Order order) {
        System.out.println("Calling " + user.getPhoneNumber());
    }
}
