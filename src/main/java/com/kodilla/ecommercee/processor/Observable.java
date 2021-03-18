package com.kodilla.ecommercee.processor;

import com.kodilla.ecommercee.domain.User;

public interface Observable {

    void notifyUsers();

    void removeUsers(User user);
}
