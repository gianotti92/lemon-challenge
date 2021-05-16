package com.lemon.wallet.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum CurrencyType {
    ARS {
        @Override
        public BigDecimal round(BigDecimal amount) {
            return amount.setScale(2, RoundingMode.HALF_EVEN);
        }
    },
    BTC {
        @Override
        public BigDecimal round(BigDecimal amount) {
            return amount.setScale(8, RoundingMode.HALF_EVEN);
        }
    },
    USDT {
        @Override
        public BigDecimal round(BigDecimal amount) {
            return amount.setScale(2, RoundingMode.HALF_EVEN);
        }
    };


    public abstract BigDecimal round(BigDecimal amount);

}
