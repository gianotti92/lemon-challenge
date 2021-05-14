package com.lemon.wallet.dto;

import java.math.BigDecimal;

public class WalletDto {
    private Long id;
    private CurrencyTypeDto currencyType;
    private BigDecimal amount;

    public WalletDto(Long id, CurrencyTypeDto currencyType, BigDecimal amount) {
        this.id = id;
        this.currencyType = currencyType;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public CurrencyTypeDto getCurrencyType() {
        return currencyType;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
