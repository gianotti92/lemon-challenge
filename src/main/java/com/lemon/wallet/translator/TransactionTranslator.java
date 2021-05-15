package com.lemon.wallet.translator;

import com.lemon.wallet.dto.TransactionDto;
import com.lemon.wallet.model.CurrencyType;
import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.model.persistence.TransactionPersistenceDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TransactionTranslator {
    public Transaction toDomain(TransactionDto transactionDto) {
        //TODO: localdatenow armar cuando se guarde
        return new Transaction(transactionDto.getId(), transactionDto.getUserFrom(), transactionDto.getUserTo(),
                LocalDateTime.now(), transactionDto.getAmount(), CurrencyType.valueOf(transactionDto.getCurrencyType().name()));
    }

    public TransactionDto toDto(Transaction movement) {
        return null;
    }

    public TransactionPersistenceDto toPersistence(Transaction transaction) {
        return null;
    }

    public Transaction toDomain(TransactionPersistenceDto transactionPersisted) {
        return null;
    }
}
