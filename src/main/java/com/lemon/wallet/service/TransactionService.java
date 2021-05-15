package com.lemon.wallet.service;

import com.lemon.wallet.client.TransactionWalletClient;
import com.lemon.wallet.exception.ApiException;
import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.model.Wallet;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionService {

    private final WalletService WalletService;
    private final TransactionWalletClient transactionWalletClient;

    public TransactionService(WalletService walletService, TransactionWalletClient transactionWalletClient) {
        WalletService = walletService;
        this.transactionWalletClient = transactionWalletClient;
    }

    @Transactional(rollbackFor = Exception.class)
    public Transaction createMovement(Transaction transaction) {

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
