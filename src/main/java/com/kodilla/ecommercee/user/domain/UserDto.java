package com.kodilla.ecommercee.user.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String userName;
    private Integer status;
    private Long userKey;
}
