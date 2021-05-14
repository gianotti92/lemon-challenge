package com.lemon.wallet.service;

import com.lemon.wallet.client.PersistenceUserClient;
import com.lemon.wallet.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private PersistenceUserClient persistenceUserClient;

    public UserService(PersistenceUserClient persistenceUserClient) {
        this.persistenceUserClient = persistenceUserClient;
    }

    public User find(Long id) {
        return persistenceUserClient.find(id);
    }

    public User saveUser(User user) {
        return persistenceUserClient.save(user);
    }
}
