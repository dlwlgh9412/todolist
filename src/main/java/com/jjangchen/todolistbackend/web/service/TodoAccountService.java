package com.jjangchen.todolistbackend.web.service;

import com.jjangchen.todolistbackend.entity.TodoAccount;
import com.jjangchen.todolistbackend.enums.TodoOauthType;
import com.jjangchen.todolistbackend.exception.TodoAccountNotFoundException;
import com.jjangchen.todolistbackend.repository.TodoAccountRepository;
import com.jjangchen.todolistbackend.web.aop.authentication.context.TodoAuthenticationContextHolder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class TodoAccountService {
    private final TodoAccountRepository todoAccountRepository;

    public Optional<TodoAccount> loadUser(Long id, TodoOauthType socialType) {
        return todoAccountRepository.findByIdAndSocialType(id, socialType);
    }

    public TodoAccount loadAccountByUsername(String id) {
        return todoAccountRepository.findById(id).orElseThrow(TodoAccountNotFoundException::new);
    }

    public TodoAccount loadAccountByContext() {
        return (TodoAccount) TodoAuthenticationContextHolder.getContext().getTodoAuthentication().getPrincipal();
    }

    public void deleteAccount() {
        todoAccountRepository.delete(loadAccountByContext());
    }
}
