package com.lemon.wallet.translator;

import com.lemon.wallet.dto.CurrencyTypeDto;
import com.lemon.wallet.dto.TransactionDto;
import com.lemon.wallet.dto.TransactionFilterDto;
import com.lemon.wallet.dto.TransactionTypeDto;
import com.lemon.wallet.model.CurrencyType;
import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.model.TransactionFilter;
import com.lemon.wallet.model.TransactionType;
import com.lemon.wallet.model.persistence.TransactionPersistenceDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class TransactionTranslator {

    private static final String TRANSACTION_TYPE_DEFAULT = TransactionTypeDto.MOVEMENT.name();
    private static final String CURRENCY_TYPE_DEFAULT = CurrencyTypeDto.ARS.name();
    private static final int LIMIT_RESULT_DEFAULT = 10;
    private static final int LIMIT_OFFSET_DEFAULT = 0;

    public Transaction toDomain(TransactionDto transactionDto) {
        return new Transaction(transactionDto.getId(), transactionDto.getUserFrom(),
                transactionDto.getUserTo(), new BigDecimal(transactionDto.getAmount()), CurrencyType.valueOf(transactionDto.getCurrencyType().name()),
                TransactionType.valueOf(transactionDto.getTransactionType().name()));
    }

    public TransactionDto toDto(Transaction transaction) {
        return new TransactionDto(transaction.getId(), transaction.getUserFrom(), transaction.getUserTo(), transaction.getAmount().toPlainString(),
                CurrencyTypeDto.valueOf(transaction.getCurrencyType().name()), transaction.getCreationDate(),
                TransactionTypeDto.valueOf(transaction.getTransactionType().name()));
    }

    public TransactionPersistenceDto toPersistence(Transaction transaction) {
        return new TransactionPersistenceDto(transaction.getUserFrom(), transaction.getUserTo(),
                transaction.getAmount(), LocalDateTime.now(), transaction.getCurrencyType(), transaction.getTransactionType());
    }

    public Transaction toDomain(TransactionPersistenceDto transactionPersisted) {
        return new Transaction(transactionPersisted.getId(), transactionPersisted.getUserFrom(), transactionPersisted.getUserTo(),
                transactionPersisted.getAmount(), transactionPersisted.getCurrencyType(), transactionPersisted.getCreationDate(),
                transactionPersisted.getTransactionType());
    }

    public TransactionFilter toDomain(TransactionFilterDto filter) {

        var limit = Optional.ofNullable(filter.getLimit()).orElse(LIMIT_RESULT_DEFAULT);
        var offset = Optional.ofNullable(filter.getOffset()).orElse(LIMIT_OFFSET_DEFAULT);

        Optional<CurrencyTypeDto> optionalCurrencyType = Optional.ofNullable(filter.getCurrencyType());

        Optional<TransactionTypeDto> optionalTransactionType = Optional.ofNullable(filter.getTransactionType());

            return new TransactionFilter(CurrencyType.valueOf(optionalCurrencyType.map(CurrencyTypeDto::name).orElse(CURRENCY_TYPE_DEFAULT)),
                    TransactionType.valueOf(optionalTransactionType.map(TransactionTypeDto::name).orElse(TRANSACTION_TYPE_DEFAULT)),
                    offset, limit);
    }
}
