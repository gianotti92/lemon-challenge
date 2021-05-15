package com.lemon.wallet.adapter;

import com.lemon.wallet.dto.TransactionDto;
import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.service.TransactionMovementService;
import com.lemon.wallet.strategy.TransactionSelectionStrategy;
import com.lemon.wallet.strategy.TransactionStrategy;
import com.lemon.wallet.translator.TransactionTranslator;
import org.springframework.stereotype.Component;

@Component
public class TransactionAdapter {
    private final TransactionTranslator transactionTranslator;
    private final TransactionSelectionStrategy transactionSelectionStrategy;

    public TransactionAdapter(TransactionTranslator transactionTranslator,
                              TransactionSelectionStrategy transactionSelectionStrategy) {
        this.transactionTranslator = transactionTranslator;
        this.transactionSelectionStrategy = transactionSelectionStrategy;
    }

    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction transaction = transactionTranslator.toDomain(transactionDto);

        TransactionStrategy strategy = transactionSelectionStrategy.getStrategy(transaction.getTransactionType());

        return transactionTranslator.toDto(strategy.createTransaction(transaction));
    }
}
