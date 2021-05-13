package com.lemon.wallet.user.service;

import com.lemon.wallet.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserCrudService {

    private UserService userService;

    public UserCrudService(UserService userService) {
        this.userService = userService;
    }

    public User createUser(User user) {

        return null;
    }
}
