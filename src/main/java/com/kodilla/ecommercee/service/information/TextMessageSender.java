package com.kodilla.ecommercee.service.information;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;

public class TextMessageSender implements Notificators {
    @Override
    public void notifyOrderCreated(Order order, User user) {
        System.out.println("new order " + order.getId() + " was created. Please find more details on provided e-mail: " + user.getEmail());
    }

    @Override
    public void notifyOrderVerified(User user, Order order) {
        System.out.println("TEXT MESSAGE SEND TO CUSTOMER");
        System.out.println("order " + order.getId() + "has been verified.");
    }

    @Override
    public void notifyOrderPaid(User user, Order order) {
        System.out.println("TEXT MESSAGE SEND TO CUSTOMER");
        System.out.println("payment for order " + order.getId() + "has been confirmed.");
    }

    @Override
    public void notifyOrderSent(User user, Order order) {
        System.out.println("TEXT MESSAGE SEND TO CUSTOMER");
        System.out.println("order " + order.getId() + "has been sent.");
    }
}
