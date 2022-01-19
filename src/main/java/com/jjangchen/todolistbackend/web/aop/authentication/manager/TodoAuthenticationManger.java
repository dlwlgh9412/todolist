package com.jjangchen.todolistbackend.web.aop.authentication.manager;

import com.jjangchen.todolistbackend.web.aop.authentication.TodoAuthentication;

public interface TodoAuthenticationManger {
    TodoAuthentication authenticate(TodoAuthentication authentication);
}
