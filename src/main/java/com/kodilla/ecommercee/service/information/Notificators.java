package com.kodilla.ecommercee.service.information;

import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.domain.User;
import org.springframework.stereotype.Service;

@Service
public interface Notificators {
    public void notifyOrderCreated(Order order, User user);
    public void notifyOrderVerified(User user, Order order);
    public void notifyOrderPaid(User user, Order order);
    public void notifyOrderSent(User user, Order order);
}
