package com.lemon.wallet.adapter;

import com.lemon.wallet.dto.UserDto;
import com.lemon.wallet.model.User;
import com.lemon.wallet.service.WalletUserCrudService;
import com.lemon.wallet.translator.UserTranslator;
import com.lemon.wallet.translator.WalletTranslator;
import com.lemon.wallet.dto.validator.UserDtoValidator;
import org.springframework.stereotype.Component;

@Component
public class WalletUserAdapter {

    private final UserTranslator userTranslator;
    private final WalletUserCrudService walletUserCrudService;
    private final WalletTranslator walletTranslator;
    private final UserDtoValidator userDtoValidator;

    public WalletUserAdapter(UserTranslator userTranslator, WalletUserCrudService walletUserCrudService,
                             WalletTranslator walletTranslator, UserDtoValidator userDtoValidator) {
        this.userTranslator = userTranslator;
        this.walletUserCrudService = walletUserCrudService;
        this.walletTranslator = walletTranslator;
        this.userDtoValidator = userDtoValidator;
    }

    public UserDto createUser(UserDto userDto) {

        userDtoValidator.validate(userDto);

        User user = userTranslator.toDomain(userDto);

        return walletTranslator.toDto(walletUserCrudService.createUser(user));
    }

    public UserDto findUser(Long id) {
        return walletTranslator.toDto(walletUserCrudService.find(id));
    }
}
