package com.jjangchen.todolistbackend.web.aop.authentication.provider;

import com.jjangchen.todolistbackend.entity.TodoAccount;
import com.jjangchen.todolistbackend.exception.TodoAccountNotFoundException;
import com.jjangchen.todolistbackend.web.aop.authentication.TodoAuthentication;
import com.jjangchen.todolistbackend.web.aop.authentication.TodoUserAuthentication;
import com.jjangchen.todolistbackend.web.service.TodoAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TodoAccountAuthenticationProvider implements TodoAuthenticationProvider {
    private final TodoAccountService accountService;

    @Override
    public TodoAuthentication authenticate(TodoAuthentication authentication) {
        String username = determineUsername(authentication);
        TodoAccount user = null;
        try {
            user = loadAccount(username);
        } catch (TodoAccountNotFoundException e) {
            // exception
        }

        Object principal = user;
        return createTodoAuthentication(principal);
    }

    @Override
    public boolean isSupport(Class<?> authentication) {
        return TodoUserAuthentication.class.isAssignableFrom(authentication);
    }

    private TodoAuthentication createTodoAuthentication(Object principal) {
        // 권한 기능 미구현
        return new TodoUserAuthentication(null, principal);
    }

    private String determineUsername(TodoAuthentication authentication) {
        return authentication.getName();
    }

    private TodoAccount loadAccount(String username) {
        return accountService.loadAccountByUsername(username);
    }
}
