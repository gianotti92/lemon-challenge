package com.lemon.wallet.service;

import com.lemon.wallet.client.PersistenceUserClient;
import com.lemon.wallet.exception.ApiException;
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

    public User find(Long id) {
       Optional<User> optionalUser = persistenceUserClient.find(id);

       if(optionalUser.isPresent()) {
           return optionalUser.get();
       }

       return optionalUser.orElseThrow(() -> new ApiException(String.format("User not fund, with id: %s", id)));
    }
}
