package com.lemon.wallet.translator;

import com.lemon.wallet.dto.CurrencyTypeDto;
import com.lemon.wallet.dto.WalletDto;
import com.lemon.wallet.model.User;
import com.lemon.wallet.model.Wallet;
import com.lemon.wallet.model.persistence.UserPersistenceDto;
import com.lemon.wallet.model.persistence.WalletPersistenceDto;
import org.springframework.stereotype.Component;

@Component
public class WalletTranslator {

    private final UserTranslator userTranslator;

    public WalletTranslator(UserTranslator userTranslator) {
        this.userTranslator = userTranslator;
    }

    public WalletPersistenceDto toPersistence(Wallet wallet, User user) {

        UserPersistenceDto userPersistence = userTranslator.toPersistence(user);

        return new WalletPersistenceDto(wallet.getCurrencyType(), wallet.getAmount(), userPersistence);
    }

    public Wallet toDomain(WalletPersistenceDto walletPersistence, UserPersistenceDto userPersitence) {

       User user = userTranslator.toDomain(userPersitence);

        return new Wallet(walletPersistence.getId(), walletPersistence.getCurrencyType(),
                walletPersistence.getAmount(), user);
    }

    public WalletDto toDto(Wallet wallet) {

        CurrencyTypeDto currencyType = CurrencyTypeDto.get(wallet.getCurrencyType().name());

        return new WalletDto(wallet.getId(), currencyType, wallet.getAmount());
    }
}
