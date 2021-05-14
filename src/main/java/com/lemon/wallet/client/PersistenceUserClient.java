package com.lemon.wallet.client;

import com.lemon.wallet.translator.UserTranslator;
import com.lemon.wallet.model.User;
import com.lemon.wallet.model.persistence.UserPersistenceDto;
import com.lemon.wallet.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class PersistenceUserClient {
    private final UserRepository userRepository;
    private final UserTranslator userTranslator;

    public PersistenceUserClient(UserRepository userRepository, UserTranslator userTranslator) {
        this.userRepository = userRepository;
        this.userTranslator = userTranslator;
    }

    public User save(User user) {
        UserPersistenceDto userPersistenceDto = userTranslator.toPersistence(user);

        userPersistenceDto = userRepository.save(userPersistenceDto);

        return userTranslator.toDomain(userPersistenceDto);
    }

    public User find(Long id) {
        //TODO: armar excepciones
        UserPersistenceDto user = userRepository.findById(id).orElseThrow(RuntimeException::new);

        return userTranslator.toDomain(user);
    }
}
