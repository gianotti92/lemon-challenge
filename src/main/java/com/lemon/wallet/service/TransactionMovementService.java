package com.lemon.wallet.service;

import com.lemon.wallet.client.TransactionWalletClient;
import com.lemon.wallet.exception.ApiException;
import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.model.Wallet;
import com.lemon.wallet.strategy.TransactionStrategy;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionMovementService implements TransactionStrategy {

    private final WalletService WalletService;
    private final TransactionWalletClient transactionWalletClient;

    public TransactionMovementService(WalletService walletService, TransactionWalletClient transactionWalletClient) {
        WalletService = walletService;
        this.transactionWalletClient = transactionWalletClient;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Transaction createTransaction(Transaction transaction) {

        Wallet walletFrom = WalletService.findWallet(transaction.getUserFrom(), transaction.getCurrencyType());

        Wallet walletTo = WalletService.findWallet(transaction.getUserTo(), transaction.getCurrencyType());

        validateBalance(transaction, walletFrom);

        WalletService.updateSubtract(walletFrom, transaction);

        WalletService.updateAdd(walletTo, transaction);

        return transactionWalletClient.save(transaction);
    }

    private void validateBalance(Transaction transaction, Wallet walletFrom) {
        BigDecimal fromAmountInWallet = walletFrom.getAmount();

        if(fromAmountInWallet.compareTo(transaction.getAmount()) < 0) {
            throw new ApiException(String.format("The balance of user_id: %s, is incorrect for create a movement" ,
                walletFrom.getUser().getId()));
        }
    }
}
