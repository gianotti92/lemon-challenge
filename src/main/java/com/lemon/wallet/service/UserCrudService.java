package com.lemon.wallet.service;

import com.lemon.wallet.model.User;
import com.lemon.wallet.model.Wallet;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserCrudService {

    private UserService userService;
    private WalletService walletService;

    public UserCrudService(UserService userService, WalletService walletService) {
        this.userService = userService;
        this.walletService = walletService;
    }

    @Transactional(rollbackOn = Exception.class)
    public User createUser(User user) {

         User userPersisted = userService.saveUser(user);

         List<Wallet> wallets = walletService.createWallets(userPersisted);

         return userPersisted;
    }
}
