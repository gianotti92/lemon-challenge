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

    public PersistenceWalletClient(WalletRepository walletRepository, WalletTranslator walletTranslator) {
        this.walletRepository = walletRepository;
        this.walletTranslator = walletTranslator;
    }

    public List<Wallet> createWallets(User user, Wallet... wallets) {

        List<WalletPersistenceDto> walletsToPersist = Arrays.stream(wallets)
                .map(w -> walletTranslator.toPersistence(w, user))
                .collect(Collectors.toList());

        return walletsToPersist.stream()
                .map(this::save)
                .collect(Collectors.toList());
    }

    public List<Wallet> findWallets(Long userId) {
        return walletRepository.findByUserId(userId).stream()
                .map(w -> walletTranslator.toDomain(w, w.getUser())).collect(Collectors.toList());
    }

    private Wallet save(WalletPersistenceDto walletPersistence) {
        walletPersistence = walletRepository.save(walletPersistence);

        return walletTranslator.toDomain(walletPersistence, walletPersistence.getUser());
    }

}
