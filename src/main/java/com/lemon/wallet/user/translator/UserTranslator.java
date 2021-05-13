package com.lemon.wallet.user.translator;

import com.lemon.wallet.user.dto.UserDto;
import com.lemon.wallet.user.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserTranslator {

    public User todDomain(UserDto userDto){
        return new User(userDto.getName(), userDto.getSurname(), userDto.getAlias(), userDto.getEmail());
    }

    public UserDto toDto(User user) {
        return null;
    }
}
