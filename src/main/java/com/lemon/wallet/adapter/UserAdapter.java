package com.lemon.wallet.adapter;

import com.lemon.wallet.dto.UserDto;
import com.lemon.wallet.model.User;
import com.lemon.wallet.service.UserCrudService;
import com.lemon.wallet.translator.UserTranslator;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {

    private final UserTranslator userTranslator;
    private final UserCrudService userCrudService;

    public UserAdapter(UserTranslator userTranslator, UserCrudService userCrudService) {
        this.userTranslator = userTranslator;
        this.userCrudService = userCrudService;
    }

    public UserDto createUser(UserDto userDto) {

        User user = userTranslator.toDomain(userDto);

        return userTranslator.toDto(userCrudService.createUser(user));
    }
}
