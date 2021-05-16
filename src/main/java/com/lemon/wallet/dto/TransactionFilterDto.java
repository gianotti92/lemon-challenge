package com.lemon.wallet.dto;

public class TransactionFilterDto {

    private CurrencyTypeDto currencyTypeDto;
    private TransactionTypeDto transactionTypeDto;
    private Integer offset;
    private Integer limit;

    public TransactionFilterDto() {
        //for mapper
    }

    public TransactionFilterDto(CurrencyTypeDto currencyTypeDto, TransactionTypeDto transactionTypeDto, Integer offset, Integer limit) {
        this.currencyTypeDto = currencyTypeDto;
        this.transactionTypeDto = transactionTypeDto;
        this.offset = offset;
        this.limit = limit;
    }

    public CurrencyTypeDto getCurrencyTypeDto() {
        return currencyTypeDto;
    }

    public TransactionTypeDto getTransactionTypeDto() {
        return transactionTypeDto;
    }

    public Integer getOffset() {
        return offset;
    }

    public Integer getLimit() {
        return limit;
    }
}
