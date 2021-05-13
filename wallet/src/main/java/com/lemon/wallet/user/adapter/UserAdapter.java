package com.lemon.wallet.user.adapter;

import com.lemon.wallet.user.dto.UserDto;
import com.lemon.wallet.user.model.User;
import com.lemon.wallet.user.service.UserCrudService;
import com.lemon.wallet.user.translator.UserTranslator;
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

        User user = userTranslator.todDomain(userDto);

        return userTranslator.toDto(userCrudService.createUser(user));
    }
}
