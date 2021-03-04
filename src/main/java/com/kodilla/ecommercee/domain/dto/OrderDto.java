package com.kodilla.ecommercee.domain.dto;


import com.kodilla.ecommercee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private User userId;
    private boolean paid, verified, sent;
}
