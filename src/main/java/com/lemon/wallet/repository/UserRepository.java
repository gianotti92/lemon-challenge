package com.lemon.wallet.repository;

import com.lemon.wallet.model.persistence.UserPersistenceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserPersistenceDto, Long> {
}
