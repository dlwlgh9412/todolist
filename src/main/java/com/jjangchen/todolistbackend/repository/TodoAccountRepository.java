package com.jjangchen.todolistbackend.repository;

import com.jjangchen.todolistbackend.entity.TodoAccount;
import com.jjangchen.todolistbackend.enums.TodoSocialType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoAccountRepository extends JpaRepository<TodoAccount, Long> {
    Optional<TodoAccount> findById(String id);
    Optional<TodoAccount> findByIdAndSocialType(String id, TodoSocialType socialType);
}
