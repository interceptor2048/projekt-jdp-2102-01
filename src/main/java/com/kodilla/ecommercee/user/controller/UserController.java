package com.kodilla.ecommercee.user.controller;

import com.kodilla.ecommercee.user.domain.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @RequestMapping(method = RequestMethod.PUT, value = "createUser")
    public void createUser(UserDto userDto) {

    }

    @RequestMapping(method = RequestMethod.POST, value = "banUser")
    public UserDto banUser(UserDto userDto) {
        return new UserDto(1L,"Piotr", 1,59403L);
    }

    @RequestMapping(method = RequestMethod.POST, value = "generateRandomKey")
    public UserDto generateRandomKey(UserDto userDto) {
        return new UserDto(1L,"Piotr",0,91735L);
    }

}
