package com.lemon.wallet.service;

import com.lemon.wallet.client.PersistenceTransactionClient;
import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.model.TransactionFilter;
import com.lemon.wallet.model.TransactionType;
import com.lemon.wallet.model.persistence.TransactionPersistenceDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionFindService {
    private final PersistenceTransactionClient persistenceTransactionClient;

    public TransactionFindService(PersistenceTransactionClient persistenceTransactionClient) {
        this.persistenceTransactionClient = persistenceTransactionClient;
    }

    public List<Transaction> find(TransactionFilter filter) {
        return persistenceTransactionClient.find(filter);
    }
}
