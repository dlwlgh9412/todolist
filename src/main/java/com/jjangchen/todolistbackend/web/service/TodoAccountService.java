package com.jjangchen.todolistbackend.web.service;

import com.jjangchen.todolistbackend.entity.TodoAccount;
import com.jjangchen.todolistbackend.exception.TodoAccountNotFoundException;
import com.jjangchen.todolistbackend.repository.TodoAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class TodoAccountService {
    private final TodoAccountRepository todoAccountRepository;

    public TodoAccount loadAccountByUsername(String name) {
        return todoAccountRepository.findByUsername(name).orElseThrow(TodoAccountNotFoundException::new);
    }
}
