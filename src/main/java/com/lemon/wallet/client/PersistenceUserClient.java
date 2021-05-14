package com.lemon.wallet.client;

import com.lemon.wallet.translator.UserTranslator;
import com.lemon.wallet.model.User;
import com.lemon.wallet.model.persistence.UserPersistenceDto;
import com.lemon.wallet.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    public Optional<User> find(Long id) {
        Optional<UserPersistenceDto> optionalUserPersistence = userRepository.findById(id);

        return optionalUserPersistence.map(userTranslator::toDomain);
    }

    public Optional<User> find(String email, String alias) {
        Optional<UserPersistenceDto> optionalUserPersistence = userRepository.findByEmailAndAlias(email, alias);

        return optionalUserPersistence.map(userTranslator::toDomain);
    }
}
