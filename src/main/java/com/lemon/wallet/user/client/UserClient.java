package com.lemon.wallet.user.client;

import com.lemon.wallet.user.model.User;
import com.lemon.wallet.user.model.persistence.UserPersistenceDto;
import com.lemon.wallet.user.repository.UserRepository;
import com.lemon.wallet.user.translator.UserTranslator;
import org.springframework.stereotype.Component;

@Component
public class UserClient {
    private final UserRepository userRepository;
    private final UserTranslator userTranslator;

    public UserClient(UserRepository userRepository, UserTranslator userTranslator) {
        this.userRepository = userRepository;
        this.userTranslator = userTranslator;
    }

    public User save(User user) {
        UserPersistenceDto userPersistenceDto = userTranslator.toPersistence(user);

        userPersistenceDto = userRepository.save(userPersistenceDto);

        return userTranslator.todDomain(userPersistenceDto);
    }
}
