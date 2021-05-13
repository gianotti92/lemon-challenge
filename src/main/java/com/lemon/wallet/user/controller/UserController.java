package com.lemon.wallet.user.controller;

import com.lemon.wallet.user.adapter.UserAdapter;
import com.lemon.wallet.user.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lemon/user-api/user")
public class UserController {

    private final UserAdapter userAdapter;

    public UserController(UserAdapter userAdapter) {
        this.userAdapter = userAdapter;
    }

    @GetMapping
    public UserDto getUsersByFilter() {
        return null;

    }

    @GetMapping("{/userId}")
    public UserDto getUserById(@PathVariable("userId") Long userId) {
        return null;
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userAdapter.createUser(userDto);
    }

}
