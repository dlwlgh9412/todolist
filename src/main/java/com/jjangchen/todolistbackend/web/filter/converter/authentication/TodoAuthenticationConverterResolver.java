package com.jjangchen.todolistbackend.web.filter.converter.authentication;

public interface TodoAuthenticationConverterResolver<T> {
    TodoAuthenticationConverter resolve(T type);
}
