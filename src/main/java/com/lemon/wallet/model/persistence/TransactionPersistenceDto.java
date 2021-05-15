package com.lemon.wallet.model.persistence;

import com.lemon.wallet.model.CurrencyType;
import com.lemon.wallet.model.TransactionType;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="transaction")
@EntityListeners(AuditingEntityListener.class)
public class TransactionPersistenceDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="id_user_from")
    private Long userFrom;
    @Column(name ="id_user_to")
    private Long userTo;
    @CreatedDate
    @Column(name ="creation_date")
    private LocalDateTime creationDate;
    @Column(name ="amount")
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    @Column(name ="currency_type")
    private CurrencyType currencyType;
    @Column(name = "transaction_type")
    private TransactionType transactionType;

    public TransactionPersistenceDto() {
        //for hibernate
    }

    public TransactionPersistenceDto(Long userFrom,
                                      Long userTo,
                                      BigDecimal amount,
                                      LocalDateTime creationDate,
                                      CurrencyType currencyType, TransactionType transactionType) {
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.creationDate = creationDate;
        this.amount = amount;
        this.currencyType = currencyType;
        this.transactionType = transactionType;
    }


    public Long getId() {
        return id;
    }

    public Long getUserFrom() {
        return userFrom;
    }

    public Long getUserTo() {
        return userTo;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}
