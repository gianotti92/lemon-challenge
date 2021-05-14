package com.lemon.wallet.translator;

import com.lemon.wallet.dto.TransactionDto;
import com.lemon.wallet.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionTranslator {
    public Transaction toDomain(TransactionDto transactionDto) {
        return null;
    }

    public TransactionDto toDto(Transaction movement) {
        return null;
    }
}
