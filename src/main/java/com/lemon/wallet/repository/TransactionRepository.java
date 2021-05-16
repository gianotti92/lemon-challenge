package com.lemon.wallet.repository;

import com.lemon.wallet.model.CurrencyType;
import com.lemon.wallet.model.TransactionType;
import com.lemon.wallet.model.persistence.TransactionPersistenceDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionPersistenceDto, Long> {

    List<TransactionPersistenceDto> findAllByCurrencyTypeAndTransactionType(CurrencyType currencyType, TransactionType transactionType, Pageable pageable);
}
