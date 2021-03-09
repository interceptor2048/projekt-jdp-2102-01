package com.kodilla.ecommercee.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CartNotFoundException extends Exception{
    private static  final String MESSAGE="Cart not found!";

    public CartNotFoundException(){super(MESSAGE);}
}


