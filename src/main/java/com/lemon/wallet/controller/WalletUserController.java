package com.lemon.wallet.controller;

import com.lemon.wallet.adapter.WalletUserAdapter;
import com.lemon.wallet.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lemon/challenge-api/user")
public class WalletUserController {

    private static final Logger LOG = LoggerFactory.getLogger(WalletUserController.class);

    private final WalletUserAdapter walletUserAdapter;

    public WalletUserController(WalletUserAdapter walletUserAdapter) {
        this.walletUserAdapter = walletUserAdapter;
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        LOG.info(String.format("Creating user with alias: %s", userDto.getAlias()));
        var response = walletUserAdapter.createUser(userDto);
        LOG.info(String.format("finish user with alias: %s, with response: %s", userDto.getAlias(), response));
        return response;
    }

    @GetMapping("/{userId}")
    public UserDto getUserById(@PathVariable("userId") Long userId) {
        LOG.info(String.format("Find user by id: %s", userId));
        var response= walletUserAdapter.findUser(userId);
        LOG.info(String.format("Finish user by id: %s, with response: %s", userId, response));
        return response;
    }

}
