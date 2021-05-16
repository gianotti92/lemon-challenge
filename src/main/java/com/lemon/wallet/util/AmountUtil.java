package com.lemon.wallet.util;

import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.model.Wallet;

import java.math.BigDecimal;

public class AmountUtil {

    public static Transaction formatAmount(Transaction transaction) {

        BigDecimal amountPersisted = transaction.getAmount();

        var updatedAmount = transaction.getCurrencyType().round(amountPersisted);

        return new Transaction(transaction.getId(), transaction.getUserFrom(), transaction.getUserTo(), updatedAmount,
                transaction.getCurrencyType(), transaction.getCreationDate(), transaction.getTransactionType());

    }

    public static Wallet formatAmount(Wallet wallet) {

        BigDecimal amountPersisted = wallet.getAmount();

        var updatedAmount = wallet.getCurrencyType().round(amountPersisted);

        return new Wallet(wallet.getId(), wallet.getCurrencyType(), updatedAmount, wallet.getUser());

    }
}
