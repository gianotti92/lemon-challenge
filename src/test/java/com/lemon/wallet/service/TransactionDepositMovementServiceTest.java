package com.lemon.wallet.service;

import com.lemon.wallet.client.PersistenceTransactionClient;
import com.lemon.wallet.exception.ApiException;
import com.lemon.wallet.model.CurrencyType;
import com.lemon.wallet.model.Transaction;
import com.lemon.wallet.model.Wallet;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TransactionDepositMovementServiceTest {
    public static final long SOME_USER_ID = 1L;
    public static final CurrencyType SOME_CURRENCY_TYPE = CurrencyType.ARS;
    @InjectMocks
    private TransactionDepositMovementService transactionDepositMovementService;

    @Mock
    private WalletService walletService;

    @Mock
    private PersistenceTransactionClient persistenceTransactionClient;

    @Mock
    private Transaction transaction;

    @Mock
    private ApiException apiException;

    @Mock
    private Wallet wallet;

    @Test
    public void createTransactionFail() {
        when(transaction.getAmount()).thenReturn(new BigDecimal(-20));

        apiException = Assertions.assertThrows(ApiException.class, () -> transactionDepositMovementService.createTransaction(transaction));

        Assertions.assertEquals("Error depositing money, invalid amount", apiException.getMessage());
    }

    @Test
    public void createTransactionOk() {
        when(transaction.getAmount()).thenReturn(new BigDecimal(10));
        when(transaction.getUserTo()).thenReturn(SOME_USER_ID);
        when(transaction.getCurrencyType()).thenReturn(SOME_CURRENCY_TYPE);

        when(walletService.findWallet(SOME_USER_ID, SOME_CURRENCY_TYPE)).thenReturn(wallet);

        when(persistenceTransactionClient.save(transaction)).thenReturn(transaction);

        var response = transactionDepositMovementService.createTransaction(transaction);

        verify(walletService, times(1)).findWallet(SOME_USER_ID, SOME_CURRENCY_TYPE);
        verify(walletService, times(1)).updateAdd(wallet, transaction);
        verify(persistenceTransactionClient, times(1)).save(transaction);
    }
}
