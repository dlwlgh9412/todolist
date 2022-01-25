package com.jjangchen.todolistbackend.web.filter.converter.authentication;

import com.jjangchen.todolistbackend.exception.TodoException;

public class TodoAuthenticationResolverException extends TodoException {
    public TodoAuthenticationResolverException() {
    }

    public TodoAuthenticationResolverException(String msg) {
        super(msg);
    }
}
