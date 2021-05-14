package com.lemon.wallet.repository;

import com.lemon.wallet.model.persistence.UserPersistenceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserPersistenceDto, Long> {

    Optional<UserPersistenceDto> findByEmailAndAlias(String email, String alias);
}
