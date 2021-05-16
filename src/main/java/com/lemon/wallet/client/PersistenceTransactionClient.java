package com.lemon.wallet.client;

import com.lemon.wallet.model.CurrencyType;
import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.model.TransactionFilter;
import com.lemon.wallet.model.TransactionType;
import com.lemon.wallet.model.persistence.TransactionPersistenceDto;
import com.lemon.wallet.repository.TransactionRepository;
import com.lemon.wallet.translator.TransactionTranslator;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersistenceTransactionClient {

    private final TransactionRepository transactionRepository;
    private final TransactionTranslator transactionTranslator;

    public PersistenceTransactionClient(TransactionRepository transactionRepository, TransactionTranslator transactionTranslator) {
        this.transactionRepository = transactionRepository;
        this.transactionTranslator = transactionTranslator;
    }

    public Transaction save(Transaction transaction) {
        TransactionPersistenceDto transactionPersisted
                = transactionRepository.save(transactionTranslator.toPersistence(transaction));

        return transactionTranslator.toDomain(transactionPersisted);
    }

    public List<Transaction> find(TransactionFilter filter) {

        List<TransactionPersistenceDto> transactions = transactionRepository.findAllByCurrencyTypeAndTransactionType(filter.getCurrencyType(), filter.getTransactionType(),
                PageRequest.of(filter.getOffset(), filter.getLimit()));

        return transactions.stream().map(transactionTranslator::toDomain).collect(Collectors.toList());
    }
}
