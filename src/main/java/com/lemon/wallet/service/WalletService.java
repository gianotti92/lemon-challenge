package com.lemon.wallet.service;

import com.lemon.wallet.client.PersistenceWalletClient;
import com.lemon.wallet.model.CurrencyType;
import com.lemon.wallet.model.Wallet;
import com.lemon.wallet.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WalletService {

    private final PersistenceWalletClient persistenceWalletClient;

    public WalletService(PersistenceWalletClient persistenceWalletClient) {
        this.persistenceWalletClient = persistenceWalletClient;
    }

    public List<Wallet> createWallets(User persistedUser) {

        List<Wallet> walletsPersisted = persistenceWalletClient.findWallets(persistedUser.getId());

        if(!walletsPersisted.isEmpty()) {
            return walletsPersisted;
        }

        Wallet btcWallet = new Wallet(CurrencyType.BTC, BigDecimal.ZERO, persistedUser);
        Wallet arsWallet = new Wallet(CurrencyType.ARS, BigDecimal.ZERO, persistedUser);
        Wallet usdtWallet = new Wallet(CurrencyType.USDT, BigDecimal.ZERO, persistedUser);

        return persistenceWalletClient.createWallets(persistedUser, btcWallet, arsWallet, usdtWallet);
    }

    public List<Wallet> findWallets(Long userId) {
        return persistenceWalletClient.findWallets(userId);
    }
}
