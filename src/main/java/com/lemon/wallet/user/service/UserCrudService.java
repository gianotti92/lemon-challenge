package com.lemon.wallet.user.service;

import com.lemon.wallet.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserCrudService {

    private UserService userService;
    private WalletService walletService;

    public UserCrudService(UserService userService, WalletService walletService) {
        this.userService = userService;
        this.walletService = walletService;
    }

    public User createUser(User user) {

         User userPersisted = userService.saveUser(user);


        walletService.createWallets(user);

    }
}
