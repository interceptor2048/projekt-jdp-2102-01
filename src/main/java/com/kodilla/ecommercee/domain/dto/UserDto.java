package com.kodilla.ecommercee.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String userName;
    private Integer status;
    private Long userKey;
    private LocalDateTime localDateTime;

    public UserDto(Long id, String userName, Integer status, Long userKey) {
        this.id = id;
        this.userName = userName;
        this.status = status;
        this.userKey = userKey;
    }
}
