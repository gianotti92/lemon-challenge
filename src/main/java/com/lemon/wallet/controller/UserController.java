package com.lemon.wallet.controller;

import com.lemon.wallet.adapter.UserAdapter;
import com.lemon.wallet.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lemon/user-api/user")
public class UserController {

    private final UserAdapter userAdapter;

    public UserController(UserAdapter userAdapter) {
        this.userAdapter = userAdapter;
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userAdapter.createUser(userDto);
    }
    @GetMapping
    public UserDto getUsersByFilter() {
        return null;
    }

    @GetMapping("{/userId}")
    public UserDto getUserById(@PathVariable("userId") Long userId) {
        return null;
    }


}
