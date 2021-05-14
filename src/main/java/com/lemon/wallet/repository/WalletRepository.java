package com.lemon.wallet.repository;

import com.lemon.wallet.model.Wallet;
import com.lemon.wallet.model.persistence.WalletPersistenceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WalletRepository extends JpaRepository<WalletPersistenceDto, Long> {
    List<WalletPersistenceDto> findByUserId(Long userId);
}
