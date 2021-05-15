package com.lemon.wallet.repository;

import com.lemon.wallet.model.persistence.TransactionPersistenceDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionPersistenceDto, Long> {
}
