package com.lemon.wallet.client;

import com.lemon.wallet.repository.WalletRepository;
import com.lemon.wallet.translator.WalletTranslator;
import com.lemon.wallet.model.User;
import com.lemon.wallet.model.Wallet;
import com.lemon.wallet.model.persistence.WalletPersistenceDto;
import com.lemon.wallet.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersistenceWalletClient {

    private final WalletRepository walletRepository;
    private final WalletTranslator walletTranslator;
    private final UserRepository userRepository;

    public PersistenceWalletClient(WalletRepository walletRepository, WalletTranslator walletTranslator, UserRepository userRepository) {
        this.walletRepository = walletRepository;
        this.walletTranslator = walletTranslator;
        this.userRepository = userRepository;
    }

    public List<Wallet> createWallets(User user, Wallet... wallets) {

        List<WalletPersistenceDto> walletsToPersist = Arrays.stream(wallets)
                .map(w -> walletTranslator.toPersistence(w, user))
                .collect(Collectors.toList());

        return walletsToPersist.stream().map(w -> save(w, user)).collect(Collectors.toList());
    }

    private Wallet save(WalletPersistenceDto walletPersistence, User user) {
        walletPersistence = walletRepository.save(walletPersistence);

        return walletTranslator.toDomain(walletPersistence, user);
    }
}
