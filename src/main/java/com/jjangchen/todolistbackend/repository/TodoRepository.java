package com.jjangchen.todolistbackend.repository;

import com.jjangchen.todolistbackend.entity.Todo;
import com.jjangchen.todolistbackend.entity.TodoAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findAllByTodoAccount(TodoAccount account);
}
