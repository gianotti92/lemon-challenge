package com.lemon.wallet.user.repository;

import com.lemon.wallet.user.model.persistence.UserPersistenceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserPersistenceDto, Long> {
}
