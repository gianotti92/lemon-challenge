package com.lemon.wallet.dto;

public class TransactionFilterDto {

    private CurrencyTypeDto currencyTypeDto;
    private TransactionTypeDto transactionTypeDto;
    private Integer offset;
    private Integer limit;

    private TransactionFilterDto() {
    }

    private TransactionFilterDto(CurrencyTypeDto currencyTypeDto, TransactionTypeDto transactionTypeDto, Integer offset, Integer limit) {
        this.currencyTypeDto = currencyTypeDto;
        this.transactionTypeDto = transactionTypeDto;
        this.offset = offset;
        this.limit = limit;
    }

    private CurrencyTypeDto getCurrencyTypeDto() {
        return currencyTypeDto;
    }

    private TransactionTypeDto getTransactionTypeDto() {
        return transactionTypeDto;
    }

    private Integer getOffset() {
        return offset;
    }

    private Integer getLimit() {
        return limit;
    }
}
