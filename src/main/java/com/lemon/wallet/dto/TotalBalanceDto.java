package com.lemon.wallet.dto;


import java.math.BigDecimal;

public class TotalBalanceDto {

    private CurrencyTypeDto currencyType;
    private String amount;

    public TotalBalanceDto(CurrencyTypeDto currencyType, String amount) {
        this.currencyType = currencyType;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TotalBalanceDto{" +
                "currencyType=" + currencyType +
                ", amount=" + amount +
                '}';
    }

    public CurrencyTypeDto getCurrencyType() {
        return currencyType;
    }

    public String getAmount() {
        return amount;
    }

}
