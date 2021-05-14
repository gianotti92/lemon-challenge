package com.lemon.wallet.model;

import java.math.BigDecimal;

public class TotalBalance {
    private CurrencyType currencyType;
    private BigDecimal amount;

    public TotalBalance(CurrencyType currencyType, BigDecimal amount) {
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
