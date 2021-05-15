package com.lemon.wallet.service;

import com.lemon.wallet.client.TransactionWalletClient;
import com.lemon.wallet.exception.ApiException;
import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.model.Wallet;
import com.lemon.wallet.strategy.TransactionStrategy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransactionDepositMovementService implements TransactionStrategy {

    private final WalletService walletService;
    private final TransactionWalletClient transactionWalletClient;

    public TransactionDepositMovementService(WalletService walletService, TransactionWalletClient transactionWalletClient) {
        this.walletService = walletService;
        this.transactionWalletClient = transactionWalletClient;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Transaction createTransaction(Transaction transaction) {

        if(transaction.getAmount().compareTo(BigDecimal.ZERO) < 0) {
            throw new ApiException("Error depositing money, invalid amount");
        }

         Wallet walletToDeposit = walletService.findWallet(transaction.getUserTo(), transaction.getCurrencyType());

         walletService.updateAdd(walletToDeposit, transaction);

         return transactionWalletClient.save(transaction);
    }
}
