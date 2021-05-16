package com.lemon.wallet.model;

public class TransactionFilter {

    private CurrencyType currencyType;
    private TransactionType transactionType;
    private Integer offset;
    private Integer limit;

    public TransactionFilter(CurrencyType currencyType, TransactionType transactionType, Integer offset, Integer limit) {
        this.currencyType = currencyType;
        this.transactionType = transactionType;
        this.offset = offset;
        this.limit = limit;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getLimit() {
        return limit;
    }
}
