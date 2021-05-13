package com.lemon.wallet.user.repository;

import com.lemon.wallet.user.model.persistence.WalletPersistenceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletRepository extends JpaRepository<WalletPersistenceDto, Long> {
}
