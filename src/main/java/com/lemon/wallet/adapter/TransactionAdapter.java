package com.lemon.wallet.adapter;

import com.lemon.wallet.dto.TransactionDto;
import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.service.TransactionService;
import com.lemon.wallet.translator.TransactionTranslator;
import org.springframework.stereotype.Component;

@Component
public class TransactionAdapter {
    private final TransactionTranslator transactionTranslator;
    private final TransactionService transactionService;

    public TransactionAdapter(TransactionService transactionService, TransactionTranslator transactionTranslator) {
        this.transactionService = transactionService;
        this.transactionTranslator = transactionTranslator;
    }

    public TransactionDto createMovement(TransactionDto transactionDto) {
        Transaction transaction = transactionTranslator.toDomain(transactionDto);

        return transactionTranslator.toDto(transactionService.createMovement(transaction));
    }
}
