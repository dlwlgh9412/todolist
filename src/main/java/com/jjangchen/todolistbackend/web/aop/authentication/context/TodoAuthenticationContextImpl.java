package com.jjangchen.todolistbackend.web.aop.authentication.context;

import com.jjangchen.todolistbackend.web.aop.authentication.TodoAuthentication;

public class TodoAuthenticationContextImpl implements TodoAuthenticationContext {
    private TodoAuthentication authentication;

    public TodoAuthenticationContextImpl() {
    }

    public TodoAuthenticationContextImpl(TodoAuthentication authentication) {
        this.authentication = authentication;
    }

    @Override
    public TodoAuthentication getTodoAuthentication() {
        return this.authentication;
    }

    @Override
    public void setTodoAuthentication(TodoAuthentication authentication) {
        this.authentication = authentication;
    }
}
