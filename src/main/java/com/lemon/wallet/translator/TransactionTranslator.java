package com.lemon.wallet.translator;

import com.lemon.wallet.dto.TransactionDto;
import com.lemon.wallet.model.CurrencyType;
import com.lemon.wallet.model.Transaction;
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
}
