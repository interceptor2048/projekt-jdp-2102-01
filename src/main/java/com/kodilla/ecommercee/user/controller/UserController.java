package com.kodilla.ecommercee.user.controller;

import com.kodilla.ecommercee.user.domain.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @PostMapping(value = "createUser")
    public void createUser(@RequestBody UserDto userDto) {
        System.out.println("User was created.");
    }

    @PutMapping(value = "banUser")
    public UserDto banUser(@RequestBody UserDto userDto) {
        return new UserDto(1L,"Piotr", 1,59403L);
    }

    @PutMapping(value = "generateRandomKey")
    public UserDto generateRandomKey(@RequestBody UserDto userDto) {
        return new UserDto(1L,"Piotr",0,91735L);
    }
}