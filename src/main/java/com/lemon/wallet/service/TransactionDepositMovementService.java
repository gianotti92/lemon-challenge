package com.lemon.wallet.service;

import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.strategy.TransactionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TransactionDepositMovementService implements TransactionStrategy {

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Transaction createTransaction(Transaction transaction) {
        return null;
    }
}
