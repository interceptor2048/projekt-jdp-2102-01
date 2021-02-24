package com.kodilla.ecommercee.user.domain;

public class UserDto {

    private Long id;
    private String userName;
    private int status;
    private Long userKey;

    public UserDto(Long id, String userName, int status, Long userKey) {
        this.id = id;
        this.userName = userName;
        this.status = status;
        this.userKey = userKey;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getStatus() {
        return status;
    }

    public Long getUserKey() {
        return userKey;
    }
}
