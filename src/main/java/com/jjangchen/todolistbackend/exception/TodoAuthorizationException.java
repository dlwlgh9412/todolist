package com.jjangchen.todolistbackend.exception;

public class TodoAuthorizationException extends TodoException {
    public TodoAuthorizationException(String msg) {
        super(msg);
    }

    public TodoAuthorizationException() {
    }
}
