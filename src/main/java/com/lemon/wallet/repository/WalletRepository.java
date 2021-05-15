package com.lemon.wallet.repository;

import com.lemon.wallet.model.CurrencyType;
import com.lemon.wallet.model.Wallet;
import com.lemon.wallet.model.persistence.WalletPersistenceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WalletRepository extends JpaRepository<WalletPersistenceDto, Long> {
    List<WalletPersistenceDto> findByUserId(Long userId);
    Optional<WalletPersistenceDto> findByUserIdAndCurrencyType(Long userId, CurrencyType currencyType);
}
