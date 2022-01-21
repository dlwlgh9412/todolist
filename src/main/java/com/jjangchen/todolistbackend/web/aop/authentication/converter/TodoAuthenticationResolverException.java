package com.jjangchen.todolistbackend.web.aop.authentication.converter;

import com.jjangchen.todolistbackend.exception.TodoException;

public class TodoAuthenticationResolverException extends TodoException {
    public TodoAuthenticationResolverException() {
    }

    public TodoAuthenticationResolverException(String msg) {
        super(msg);
    }
}
