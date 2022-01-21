package com.jjangchen.todolistbackend.web.service;

import com.jjangchen.todolistbackend.entity.TodoAccount;
import com.jjangchen.todolistbackend.exception.TodoAccountNotFoundException;
import com.jjangchen.todolistbackend.repository.TodoAccountRepository;
import com.jjangchen.todolistbackend.web.aop.authentication.context.TodoAuthenticationContextHolder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class TodoAccountService {
    private final TodoAccountRepository todoAccountRepository;

    public TodoAccount loadAccountByUsername(String name) {
        return todoAccountRepository.findByUsername(name).orElseThrow(TodoAccountNotFoundException::new);
    }

    public TodoAccount loadAccountByContext() {
        return (TodoAccount) TodoAuthenticationContextHolder.getContext().getTodoAuthentication().getPrincipal();
    }

    public String createAccount(String name) {
        return todoAccountRepository.save(new TodoAccount(name)).getUsername();
    }

    public void deleteAccount() {
        todoAccountRepository.delete(loadAccountByContext());
    }
}
