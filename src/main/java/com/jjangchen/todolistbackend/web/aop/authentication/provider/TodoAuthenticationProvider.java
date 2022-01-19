package com.jjangchen.todolistbackend.web.aop.authentication.provider;

import com.jjangchen.todolistbackend.web.aop.authentication.TodoAuthentication;

public interface TodoAuthenticationProvider {
    TodoAuthentication authenticate(TodoAuthentication authentication);
    boolean isSupport(Class<?> authentication);
}
