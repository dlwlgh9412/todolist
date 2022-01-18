package com.jjangchen.todolistbackend.web.aop.todo.exception;

import com.jjangchen.todolistbackend.exception.TodoException;

public class NotMatchTodoAuthenticationProvider extends TodoException {
    public NotMatchTodoAuthenticationProvider(String msg) {
        super(msg);
    }
}
