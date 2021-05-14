package com.lemon.wallet.model;

import java.math.BigDecimal;

public class Wallet {

    private Long id;
    private CurrencyType currencyType;
    private BigDecimal amount;
    private User user;


    public Wallet(Long id, CurrencyType currencyType, BigDecimal amount, User user) {
        this.id = id;
        this.currencyType = currencyType;
        this.amount = amount;
        this.user = user;
    }

    public Wallet(CurrencyType currencyType, BigDecimal amount, User user) {
        this.currencyType = currencyType;
        this.amount = amount;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public User getUser() {
        return user;
    }
}
