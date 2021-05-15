package com.lemon.wallet.service;

import com.lemon.wallet.client.TransactionWalletClient;
import com.lemon.wallet.exception.ApiException;
import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.model.Wallet;
import com.lemon.wallet.model.persistence.TransactionPersistenceDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
public class TransactionService {

    private final WalletService WalletService;
    private final TransactionWalletClient transactionWalletClient;

    public TransactionService(WalletService walletService, TransactionWalletClient transactionWalletClient) {
        WalletService = walletService;
        this.transactionWalletClient = transactionWalletClient;
    }

    public Transaction createMovement(Transaction transaction) {

        Wallet walletFrom = WalletService.findWallet(transaction.getUserFrom(), transaction.getCurrencyType());

        Wallet walletTo = WalletService.findWallet(transaction.getUserTo(), transaction.getCurrencyType());

        BigDecimal fromAmountInWallet = walletFrom.getAmount();

        if(fromAmountInWallet.compareTo(transaction.getAmount()) < 0) {
            throw new ApiException("lo valores estan mal"); //revisar  mensaje y exception
        }

        //realizar movimiento

        walletFrom = WalletService.updateSubtract(walletFrom, transaction);

        walletTo = WalletService.updateAdd(walletTo, transaction);


        //persistir
        return transactionWalletClient.save(transaction);
    }

}
