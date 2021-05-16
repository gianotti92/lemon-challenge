package com.lemon.wallet.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto {
    private Long id;
    private Long userFrom;
    private Long userTo;
    private LocalDateTime creationDate;
    private BigDecimal amount;
    private CurrencyTypeDto currencyType;
    private TransactionTypeDto transactionType;

    private TransactionDto() {
    }

    public TransactionDto(Long id, Long userFrom, Long userTo, BigDecimal amount, CurrencyTypeDto currencyType, LocalDateTime creationDate, TransactionTypeDto transactionType) {
        this.id = id;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.amount = amount;
        this.currencyType = currencyType;
        this.creationDate = creationDate;
        this.transactionType = transactionType;
    }

    @Override
    public String toString() {
        return "TransactionDto{" +
                "id=" + id +
                ", userFrom=" + userFrom +
                ", userTo=" + userTo +
                ", creationDate=" + creationDate +
                ", amount=" + amount +
                ", currencyType=" + currencyType +
                ", transactionType=" + transactionType +
                '}';
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

    public CurrencyTypeDto getCurrencyType() {
        return currencyType;
    }

    public TransactionTypeDto getTransactionType() {
        return transactionType;
    }
}
