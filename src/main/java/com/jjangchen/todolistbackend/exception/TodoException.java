package com.jjangchen.todolistbackend.exception;

public abstract class TodoException extends RuntimeException {
    public TodoException() {}
    public TodoException(String msg) {
        super(msg);
    }
}
