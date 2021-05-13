package com.lemon.wallet.user.dto;

import java.math.BigDecimal;

public class WalletDto {
    private CurrencyType currencyType;
    private BigDecimal amount;

    public WalletDto(CurrencyType currencyType, BigDecimal amount) {
        this.currencyType = currencyType;
        this.amount = amount;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
