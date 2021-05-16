package com.lemon.wallet.model;

import java.math.BigDecimal;

public enum CurrencyType {
    ARS {
        @Override
        public BigDecimal round(BigDecimal amount) {
            return amount.setScale(2);
        }
    },
    BTC {
        @Override
        public BigDecimal round(BigDecimal amount) {
            return amount.setScale(8);
        }
    },
    USDT {
        @Override
        public BigDecimal round(BigDecimal amount) {
            return amount.setScale(2);
        }
    };


    public abstract BigDecimal round(BigDecimal amount);

}
