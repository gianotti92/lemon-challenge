package com.lemon.wallet.service;

import com.lemon.wallet.model.User;
import com.lemon.wallet.model.Wallet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class WalletUserCrudService {

    private final UserService userService;
    private final WalletService walletService;

    public WalletUserCrudService(UserService userService, WalletService walletService) {
        this.userService = userService;
        this.walletService = walletService;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Wallet> createUser(User user) {

         User userPersisted = userService.saveUser(user);

         List<Wallet> wallets = walletService.createWallets(userPersisted);

         return wallets;
    }
    @Transactional(readOnly = true)
    public List<Wallet> find(Long userId) {
        return walletService.findWallets(userId);
    }
}
