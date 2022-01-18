package com.jjangchen.todolistbackend.web.aop.todo.authentication.converter;

public interface TodoAuthenticationConverterResolver<T> {
    TodoAuthenticationConverter resolve(T type);
}
