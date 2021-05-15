package com.lemon.wallet.translator;

import com.lemon.wallet.dto.CurrencyTypeDto;
import com.lemon.wallet.dto.TransactionDto;
import com.lemon.wallet.model.CurrencyType;
import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.model.persistence.TransactionPersistenceDto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class TransactionTranslator {

    public Transaction toDomain(TransactionDto transactionDto) {
        return new Transaction(transactionDto.getId(), transactionDto.getUserFrom(),
            transactionDto.getUserTo(), transactionDto.getAmount(), CurrencyType.valueOf(transactionDto.getCurrencyType().name()));
    }

    public TransactionDto toDto(Transaction transaction) {
        return new TransactionDto(transaction.getId(), transaction.getUserFrom(), transaction.getUserTo(), transaction.getAmount(),
            CurrencyTypeDto.valueOf(transaction.getCurrencyType().name()), transaction.getCreationDate());
    }

    public TransactionPersistenceDto toPersistence(Transaction transaction) {
        return new TransactionPersistenceDto(transaction.getUserFrom(), transaction.getUserTo(),
            transaction.getAmount(), transaction.getCurrencyType(), LocalDateTime.now());
    }

    public Transaction toDomain(TransactionPersistenceDto transactionPersisted) {
        return new Transaction(transactionPersisted.getId(), transactionPersisted.getUserFrom(), transactionPersisted.getUserTo(),
            transactionPersisted.getAmount(), transactionPersisted.getCurrencyType(), transactionPersisted.getCreationDate());
    }
}
