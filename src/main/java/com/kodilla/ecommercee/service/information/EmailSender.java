package com.kodilla.ecommercee.service.information;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.OrderItem;
import com.kodilla.ecommercee.domain.User;

public class EmailSender implements Notificators{

    @Override
    public void notifyOrderCreated(Order order, User user) {
        System.out.println("We have received order for:");
        for (OrderItem item : order.getOrderItems()) {
            System.out.println(item);
        }
        System.out.println("If you had not ordered those items please inform us immediately.");
    }

    @Override
    public void notifyOrderVerified(User user, Order order) {
            System.out.println(user.getUserName() + "  your order " + order.getId() + " has been verified. " +
                    "\nPlease proceed with chosen payment method. " +
                    "(If payement was already done please wait, we may need to process it at our side)");
        System.out.println("The details of your order are:");
        System.out.println(order.toString());
    }

    @Override
    public void notifyOrderPaid(User user, Order order) {
        System.out.println("SENDING EMAIL");
        System.out.println(user.getUserName() + " payment for your order " + order.getId() + " has been confirmed.");

    }

    @Override
    public void notifyOrderSent(User user, Order order) {
        System.out.println(user.getUserName() + " your order " + order.getId() + " has been sent to \n" + user.getAddress() +".");
    }
}
