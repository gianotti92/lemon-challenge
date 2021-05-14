package com.lemon.wallet.model;

import com.lemon.wallet.dto.CurrencyTypeDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private Long id;
    private Long userFrom;
    private Long userTo;
    private LocalDateTime date;
    private BigDecimal amount;
    private CurrencyType currencyType;

    public Transaction(Long id, Long userFrom, Long userTo, LocalDateTime date, BigDecimal amount, CurrencyType currencyType) {
        this.id = id;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.date = date;
        this.amount = amount;
        this.currencyType = currencyType;
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

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }
}
