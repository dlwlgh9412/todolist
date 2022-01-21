package com.jjangchen.todolistbackend.repository;

import com.jjangchen.todolistbackend.entity.TodoAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoAccountRepository extends JpaRepository<TodoAccount, Long> {
    Optional<TodoAccount> findByUsername(String name);
}
