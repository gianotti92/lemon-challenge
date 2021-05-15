package com.lemon.wallet.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private Long id;
    private Long userFrom;
    private Long userTo;
    private LocalDateTime creationDate;
    private BigDecimal amount;
    private CurrencyType currencyType;
    private TransactionType transactionType;

    public Transaction(Long id, Long userFrom, Long userTo, BigDecimal amount, CurrencyType currencyType, TransactionType transactionType) {
        this.id = id;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.amount = amount;
        this.currencyType = currencyType;
        this.transactionType = transactionType;
    }

    public Transaction(Long id, Long userFrom, Long userTo, BigDecimal amount, CurrencyType currencyType, LocalDateTime creationDate, TransactionType transactionType) {
        this.id = id;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.amount = amount;
        this.currencyType = currencyType;
        this.creationDate = creationDate;
        this.transactionType = transactionType;
    }

    public Long getId() {
        return id;
    }

    public Long getUserFrom() {
        return userFrom;
    }

    public Long getUserTo() {
        return userTo;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}
