package com.lemon.wallet.user.model.persistence;

import com.lemon.wallet.user.model.CurrencyType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "wallet")
public class WalletPersistenceDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="currency_type", nullable = false)
    private CurrencyType currencyType;
    @Column(name="amount", nullable = false)
    private BigDecimal amount;

    public WalletPersistenceDto() {
        //for hibernate
    }

    public WalletPersistenceDto(Long id, CurrencyType currencyType, BigDecimal amount) {
        this.id = id;
        this.currencyType = currencyType;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
