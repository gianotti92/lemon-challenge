package com.lemon.wallet.repository;

import com.lemon.wallet.model.persistence.WalletPersistenceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletPersistenceDto, Long> {
}
