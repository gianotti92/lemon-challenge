package com.lemon.wallet.user.model;

import java.math.BigDecimal;

public class Wallet {

    private CurrencyType currencyType;
    private BigDecimal amount;

    public Wallet(CurrencyType currencyType, BigDecimal amount) {
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
