package com.jjangchen.todolistbackend.web.aop.todo.authentication.provider;

import com.jjangchen.todolistbackend.web.aop.todo.authentication.TodoAuthentication;

public interface TodoAuthenticationProvider {
    TodoAuthentication authenticate(TodoAuthentication authentication);
    boolean isSupport(Class<?> authentication);
}
