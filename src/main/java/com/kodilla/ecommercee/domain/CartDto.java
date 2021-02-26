package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CartDto {

    private Long id;
    private Long userKey;
    private Long productId;
}
