package com.jjangchen.todolistbackend.exception;

public class TodoAccountNotFoundException extends TodoException {
    public TodoAccountNotFoundException() {
        super();
    }
    public TodoAccountNotFoundException(String msg) {
        super(msg);
    }
}
