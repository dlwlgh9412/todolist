package com.jjangchen.todolistbackend.web.aop.authentication.converter;

public interface TodoAuthenticationConverterResolver<T> {
    TodoAuthenticationConverter resolve(T type);
}
