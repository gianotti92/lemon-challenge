package com.lemon.wallet.service;

import com.lemon.wallet.client.PersistenceTransactionClient;
import com.lemon.wallet.model.*;
import com.lemon.wallet.model.persistence.TransactionPersistenceDto;
import com.lemon.wallet.util.AmountUtil;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionFindService {
    private final PersistenceTransactionClient persistenceTransactionClient;

    public TransactionFindService(PersistenceTransactionClient persistenceTransactionClient) {
        this.persistenceTransactionClient = persistenceTransactionClient;
    }

    public List<Transaction> find(TransactionFilter filter) {

         List<Transaction> transactions =  persistenceTransactionClient.find(filter);

         return transactions.stream().map(AmountUtil::formatAmount).collect(Collectors.toList());
    }
}
