package com.lemon.wallet.translator;

import com.lemon.wallet.dto.UserDto;
import com.lemon.wallet.model.User;
import com.lemon.wallet.model.Wallet;
import com.lemon.wallet.model.persistence.UserPersistenceDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserTranslator {

    public User toDomain(UserDto userDto) {
        return new User(userDto.getName(), userDto.getLastName(), userDto.getAlias(), userDto.getEmail());
    }

    public User toDomain(UserPersistenceDto userPersistenceDt) {
        return new User(userPersistenceDt.getId(), userPersistenceDt.getName(),
                userPersistenceDt.getLastName(), userPersistenceDt.getAlias(), userPersistenceDt.getEmail());
    }

    public UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getLastName(), user.getAlias(), user.getEmail());
    }

    public UserPersistenceDto toPersistence(User user) {
        return new UserPersistenceDto(user.getName(), user.getLastName(), user.getAlias(), user.getEmail());
    }
}
