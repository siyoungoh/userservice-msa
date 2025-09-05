package com.example.userservice.db;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class DbUserService {

    private final DbUserRepository repo;

    public DbUserService(DbUserRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public DbUserEntity create(String name, String email) {
        return repo.save(new DbUserEntity(name, email));
    }

    @Transactional(readOnly = true)
    public DbUserEntity getById(Long id) {
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found: " + id));
    }

    @Transactional(readOnly = true)
    public List<DbUserEntity> getAllUsers() {
        return repo.findAll();
    }
}