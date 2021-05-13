package com.lemon.wallet.user.translator;

import com.lemon.wallet.user.dto.UserDto;
import com.lemon.wallet.user.model.User;
import com.lemon.wallet.user.model.persistence.UserPersistenceDto;
import org.springframework.stereotype.Component;

@Component
public class UserTranslator {

    public User todDomain(UserDto userDto) {
        return new User(userDto.getName(), userDto.getLastName(), userDto.getAlias(), userDto.getEmail());
    }

    public User todDomain(UserPersistenceDto userPersistenceDt) {
        return new User(userPersistenceDt.getId(), userPersistenceDt.getName(),
                userPersistenceDt.getLastName(), userPersistenceDt.getAlias(), userPersistenceDt.getEmail());
    }

    public UserDto toDto(User user) {
        return null;
    }

    public UserPersistenceDto toPersistence(User user) {
        return new UserPersistenceDto(user.getName(), user.getLastName(), user.getAlias(), user.getEmail());
    }
}
