package com.lemon.wallet.model.persistence;

import com.lemon.wallet.model.CurrencyType;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "wallet")
public class WalletPersistenceDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="currency_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;
    @Column(name="amount", nullable = false)
    private BigDecimal amount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserPersistenceDto user;

    public WalletPersistenceDto() {
        //for hibernate
    }

    public WalletPersistenceDto(Long id, CurrencyType currencyType, BigDecimal amount, UserPersistenceDto user) {
        this.id = id;
        this.currencyType = currencyType;
        this.amount = amount;
        this.user = user;
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

    public UserPersistenceDto getUser() {
        return user;
    }
}
