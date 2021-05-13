package com.lemon.wallet.user.dto;

import java.math.BigDecimal;

public class WalletDto {
    private CurrencyTypeDto currencyType;
    private BigDecimal amount;

    public WalletDto(CurrencyTypeDto currencyType, BigDecimal amount) {
        this.currencyType = currencyType;
        this.amount = amount;
    }

    public CurrencyTypeDto getCurrencyType() {
        return currencyType;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
