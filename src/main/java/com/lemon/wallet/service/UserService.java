package com.lemon.wallet.service;

import com.lemon.wallet.client.PersistenceUserClient;
import com.lemon.wallet.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final PersistenceUserClient persistenceUserClient;

    public UserService(PersistenceUserClient persistenceUserClient) {
        this.persistenceUserClient = persistenceUserClient;
    }

    public User saveUser(User user) {
        Optional<User> optionalUserPersisted = persistenceUserClient.find(user.getEmail(), user.getAlias());

        return optionalUserPersisted.orElseGet(() -> persistenceUserClient.save(user));
    }
}
