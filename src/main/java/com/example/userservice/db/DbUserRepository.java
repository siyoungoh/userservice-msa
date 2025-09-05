package com.example.userservice.db;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DbUserRepository extends JpaRepository<DbUserEntity, Long> {
    Optional<DbUserEntity> findByEmail(String email);
}