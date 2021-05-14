package com.lemon.wallet.controller;

import com.lemon.wallet.adapter.WalletUserAdapter;
import com.lemon.wallet.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lemon/user-api/user")
public class WalletUserController {

    private final WalletUserAdapter walletUserAdapter;

    public WalletUserController(WalletUserAdapter walletUserAdapter) {
        this.walletUserAdapter = walletUserAdapter;
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return walletUserAdapter.createUser(userDto);
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable("userId") Long userId) {
        return walletUserAdapter.findUser(userId);
    }

}
