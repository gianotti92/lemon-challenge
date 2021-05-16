package com.lemon.wallet.adapter;

import com.lemon.wallet.dto.TransactionDto;
import com.lemon.wallet.dto.TransactionFilterDto;
import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.service.TransactionFindService;
import com.lemon.wallet.service.TransactionMovementService;
import com.lemon.wallet.strategy.TransactionSelectionStrategy;
import com.lemon.wallet.strategy.TransactionStrategy;
import com.lemon.wallet.translator.TransactionTranslator;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TransactionAdapter {
    private final TransactionTranslator transactionTranslator;
    private final TransactionSelectionStrategy transactionSelectionStrategy;
    private final TransactionFindService transactionFindService;

    public TransactionAdapter(TransactionTranslator transactionTranslator,
                              TransactionSelectionStrategy transactionSelectionStrategy,
                              TransactionFindService transactionFindService) {
        this.transactionTranslator = transactionTranslator;
        this.transactionSelectionStrategy = transactionSelectionStrategy;
        this.transactionFindService = transactionFindService;
    }

    public TransactionDto createTransaction(TransactionDto transactionDto) {
        Transaction transaction = transactionTranslator.toDomain(transactionDto);

        TransactionStrategy strategy = transactionSelectionStrategy.getStrategy(transaction.getTransactionType());

        return transactionTranslator.toDto(strategy.createTransaction(transaction));
    }

    public List<TransactionDto> find(TransactionFilterDto filter) {
        List<Transaction> transactions = transactionFindService.find(transactionTranslator.toDomain(filter));

        return transactions.stream().map(transactionTranslator::toDto).collect(Collectors.toList());
    }
}
