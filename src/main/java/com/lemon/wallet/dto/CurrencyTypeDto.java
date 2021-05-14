package com.lemon.wallet.dto;

import java.util.Arrays;
import java.util.Locale;

public enum CurrencyTypeDto {
    ARS,
    BTC,
    USDT;

    public static CurrencyTypeDto get(String name) {
        return Arrays.stream(CurrencyTypeDto.values())
                .filter(c -> c.name().toLowerCase(Locale.ROOT).equalsIgnoreCase(name))
                .findFirst().orElseThrow(RuntimeException::new);
    }
}
