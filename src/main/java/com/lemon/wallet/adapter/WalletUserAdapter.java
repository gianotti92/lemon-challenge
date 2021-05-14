package com.lemon.wallet.adapter;

import com.lemon.wallet.dto.UserDto;
import com.lemon.wallet.model.User;
import com.lemon.wallet.service.WalletUserCrudService;
import com.lemon.wallet.translator.UserTranslator;
import com.lemon.wallet.translator.WalletTranslator;
import com.lemon.wallet.validator.UserRequestValidator;
import org.springframework.stereotype.Component;

@Component
public class WalletUserAdapter {

    private final UserTranslator userTranslator;
    private final WalletUserCrudService walletUserCrudService;
    private final WalletTranslator walletTranslator;
    private final UserRequestValidator userRequestValidator;

    public WalletUserAdapter(UserTranslator userTranslator, WalletUserCrudService walletUserCrudService,
                             WalletTranslator walletTranslator, UserRequestValidator userRequestValidator) {
        this.userTranslator = userTranslator;
        this.walletUserCrudService = walletUserCrudService;
        this.walletTranslator = walletTranslator;
        this.userRequestValidator = userRequestValidator;
    }

    public UserDto createUser(UserDto userDto) {

        userRequestValidator.validate(userDto);

        User user = userTranslator.toDomain(userDto);

        return walletTranslator.toDto(walletUserCrudService.createUser(user));
    }

    public UserDto findUser(Long id) {
        return walletTranslator.toDto(walletUserCrudService.find(id));
    }
}
