package com.example.userservice.db;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users/db")
public class DbUserController {

    private final DbUserService service;

    public DbUserController(DbUserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateUserRequestDto req) {
        DbUserEntity saved = service.create(req.getName(), req.getEmail());
        return ResponseEntity.ok(new UserResponseDto(saved.getId(), saved.getName(), saved.getEmail()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id) {
        DbUserEntity u = service.getById(id);
        return ResponseEntity.ok(new UserResponseDto(u.getId(), u.getName(), u.getEmail()));
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<DbUserEntity> users = service.getAllUsers();
        List<UserResponseDto> response = users.stream()
                .map(user -> new UserResponseDto(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

}