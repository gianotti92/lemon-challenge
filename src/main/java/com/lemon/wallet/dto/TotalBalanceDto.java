package com.lemon.wallet.dto;

import com.lemon.wallet.model.CurrencyType;

import java.math.BigDecimal;

public class TotalBalanceDto {

    private CurrencyTypeDto currencyType;
    private BigDecimal amount;

    public TotalBalanceDto(CurrencyTypeDto currencyType, BigDecimal amount) {
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
