package com.lemon.wallet.user.service;

import com.lemon.wallet.user.client.UserClient;
import com.lemon.wallet.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserClient userClient;

    public UserService(UserClient userClient) {
        this.userClient = userClient;
    }

    public User saveUser(User user) {
        return userClient.save(user);
    }
}
