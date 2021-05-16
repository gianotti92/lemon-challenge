package com.lemon.wallet.dto;

public class WalletDto {
    private Long id;
    private CurrencyTypeDto currencyType;
    private String amount;

    public WalletDto(Long id, CurrencyTypeDto currencyType, String amount) {
        this.id = id;
        this.currencyType = currencyType;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "WalletDto{" +
                "id=" + id +
                ", currencyType=" + currencyType +
                ", amount=" + amount +
                '}';
    }

    public Long getId() {
        return id;
    }

    public CurrencyTypeDto getCurrencyType() {
        return currencyType;
    }

    public String getAmount() {
        return amount;
    }
}
