package com.lemon.wallet.translator;

import com.lemon.wallet.dto.CurrencyTypeDto;
import com.lemon.wallet.dto.TotalBalanceDto;
import com.lemon.wallet.dto.UserDto;
import com.lemon.wallet.dto.WalletDto;
import com.lemon.wallet.exception.ApiException;
import com.lemon.wallet.model.TotalBalance;
import com.lemon.wallet.model.User;
import com.lemon.wallet.model.Wallet;
import com.lemon.wallet.model.persistence.UserPersistenceDto;
import com.lemon.wallet.model.persistence.WalletPersistenceDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class WalletTranslator {

    private final UserTranslator userTranslator;

    public WalletTranslator(UserTranslator userTranslator) {
        this.userTranslator = userTranslator;
    }

    public WalletPersistenceDto toPersistence(Wallet wallet, User user) {

        UserPersistenceDto userPersistence = userTranslator.toPersistence(user);

        return new WalletPersistenceDto(wallet.getId(), wallet.getCurrencyType(), wallet.getAmount(), userPersistence);
    }

    public Wallet toDomain(WalletPersistenceDto walletPersistence) {

       User user = userTranslator.toDomain(walletPersistence.getUser());

        return new Wallet(walletPersistence.getId(), walletPersistence.getCurrencyType(),
                walletPersistence.getAmount(), user);
    }

    public WalletDto toDto(Wallet wallet) {

        CurrencyTypeDto currencyType = CurrencyTypeDto.valueOf(wallet.getCurrencyType().name());

        return new WalletDto(wallet.getId(), currencyType, wallet.getAmount().toPlainString());
    }

    public UserDto toDto(List<Wallet> wallets) {

       List<TotalBalanceDto> totals = wallets.stream().map(this::createTotal).collect(Collectors.toList());

       Optional<User> optionalUser  = wallets.stream().findAny().map(Wallet::getUser);

       User user = optionalUser.orElseThrow(() -> new ApiException("Invalid user for wallets. creating dto"));

       return new UserDto(user.getId(), user.getName(), user.getLastName(), user.getAlias(), user.getEmail(), totals);
    }

    private TotalBalanceDto createTotal(Wallet wallet) {
        return new TotalBalanceDto(CurrencyTypeDto.valueOf(wallet.getCurrencyType().name()), wallet.getAmount().toPlainString());
    }
}
