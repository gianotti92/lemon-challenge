package com.lemon.wallet.client;

import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.model.persistence.TransactionPersistenceDto;
import com.lemon.wallet.repository.TransactionRepository;
import com.lemon.wallet.translator.TransactionTranslator;
import org.springframework.stereotype.Component;

@Component
public class TransactionWalletClient {

    private final TransactionRepository transactionRepository;
    private final TransactionTranslator transactionTranslator;

    public TransactionWalletClient(TransactionRepository transactionRepository, TransactionTranslator transactionTranslator) {
        this.transactionRepository = transactionRepository;
        this.transactionTranslator = transactionTranslator;
    }

    public Transaction save(Transaction transaction) {
        TransactionPersistenceDto transactionPersisted
                = transactionRepository.save(transactionTranslator.toPersistence(transaction));

        return transactionTranslator.toDomain(transactionPersisted);

    }
}
