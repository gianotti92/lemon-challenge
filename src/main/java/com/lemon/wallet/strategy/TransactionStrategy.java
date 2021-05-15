package com.lemon.wallet.strategy;

import com.lemon.wallet.model.Transaction;

public interface TransactionStrategy {

    Transaction createTransaction(Transaction transaction);
}
