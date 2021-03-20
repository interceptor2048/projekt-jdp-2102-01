package com.kodilla.ecommercee.service.information;

import com.kodilla.ecommercee.domain.Order;

public interface Notificators {
    public void notifyOrderCreated(Order order);
    public void notifyOrderVerified(Order order);
    public void notifyOrderPaid(Order order);
    public void notifyOrderSent(Order order);
}
