package com.lemon.wallet.strategy;

import com.google.common.collect.ImmutableMap;
import com.lemon.wallet.controller.TransactionController;
import com.lemon.wallet.exception.ApiException;
import com.lemon.wallet.model.TransactionType;
import com.lemon.wallet.service.TransactionDepositMovementService;
import com.lemon.wallet.service.TransactionMovementService;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TransactionSelectionStrategy {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionSelectionStrategy.class);

    private Map<TransactionType,TransactionStrategy> strategyMap;

    public TransactionSelectionStrategy(TransactionMovementService transactionMovementService,
                                         TransactionDepositMovementService transactionDepositMovementService) {
        this.strategyMap = ImmutableMap.of(
            TransactionType.MOVEMENT, transactionMovementService,
            TransactionType.DEPOSIT, transactionDepositMovementService);
    }

    public TransactionStrategy getStrategy(TransactionType transactionType) {

        LOG.info(String.format("Start selecting strategy for transaction type: %s", transactionType.name()));

        TransactionStrategy strategy = strategyMap.get(transactionType);

         if(strategy == null) {
             throw new ApiException(String.format("Error selecting strategy for transaction type: %s", transactionType));
         }

         LOG.info(String.format("Strategy selected: %s", strategy.getClass().getName()));

         return strategy;
    }
}
