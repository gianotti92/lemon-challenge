package com.lemon.wallet.strategy;

import com.google.common.collect.ImmutableMap;
import com.lemon.wallet.exception.ApiException;
import com.lemon.wallet.model.TransactionType;
import com.lemon.wallet.service.TransactionDepositMovementService;
import com.lemon.wallet.service.TransactionMovementService;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class TransactionSelectionStrategy {

    private Map<TransactionType,TransactionStrategy> strategyMap;

    public TransactionSelectionStrategy(TransactionMovementService transactionMovementService,
                                         TransactionDepositMovementService transactionDepositMovementService) {
        this.strategyMap = ImmutableMap.of(
            TransactionType.MOVEMENT, transactionMovementService,
            TransactionType.DEPOSIT, transactionDepositMovementService);
    }

    public TransactionStrategy getStrategy(TransactionType transactionType) {

        TransactionStrategy strategy = strategyMap.get(transactionType);

         if(strategy == null) {
             throw new ApiException(String.format("Error selecting strategy for transaction type: %s", transactionType));
         }

         return strategy;
    }
}
