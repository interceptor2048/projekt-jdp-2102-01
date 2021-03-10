package com.kodilla.ecommercee.controller.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ProductConflictException extends Exception {
    private static final String MESSAGE = "Product already exist";

    public ProductConflictException() {
        super(MESSAGE);
    }

}
