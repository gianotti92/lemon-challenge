package com.lemon.wallet.dto;

public class TransactionFilterDto {

    private CurrencyTypeDto currencyType;
    private TransactionTypeDto transactionType;
    private Integer offset;
    private Integer limit;

    public TransactionFilterDto() {
        //for mapper
    }

    public CurrencyTypeDto getCurrencyType() {
        return currencyType;
    }

    public TransactionTypeDto getTransactionType() {
        return transactionType;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setCurrencyType(CurrencyTypeDto currencyType) {
        this.currencyType = currencyType;
    }

    public void setTransactionType(TransactionTypeDto transactionType) {
        this.transactionType = transactionType;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
