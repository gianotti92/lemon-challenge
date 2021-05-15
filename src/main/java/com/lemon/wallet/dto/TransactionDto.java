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

    private TransactionDto() {
    }

    public TransactionDto(Long id, Long userFrom, Long userTo, BigDecimal amount, CurrencyTypeDto currencyType) {
        this.id = id;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.amount = amount;
        this.currencyType = currencyType;
    }

    public TransactionDto(Long id, Long userFrom, Long userTo, BigDecimal amount, CurrencyTypeDto currencyType, LocalDateTime creationDate) {
        this.id = id;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.amount = amount;
        this.currencyType = currencyType;
        this.creationDate = creationDate;
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
}
