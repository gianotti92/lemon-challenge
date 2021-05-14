package com.lemon.wallet.model;

public enum CurrencyType {
    ARS("ars"),
    BTC("btc"),
    USDT("usdt");

    private final String description;

    CurrencyType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
