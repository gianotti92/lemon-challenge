package com.lemon.wallet.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDto {
    private Long id;
    private Long userFrom;
    private Long userTo;
    private LocalDateTime date;
    private BigDecimal amount;
    private CurrencyTypeDto currencyType;

    public TransactionDto(Long id, Long userFrom, Long userTo, LocalDateTime date, BigDecimal amount, CurrencyTypeDto currencyType) {
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

    public CurrencyTypeDto getCurrencyType() {
        return currencyType;
    }
}
