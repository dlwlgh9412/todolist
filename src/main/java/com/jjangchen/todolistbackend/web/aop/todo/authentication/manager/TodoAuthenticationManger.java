package com.jjangchen.todolistbackend.web.aop.todo.authentication.manager;

import com.jjangchen.todolistbackend.web.aop.todo.authentication.TodoAuthentication;

public interface TodoAuthenticationManger {
    TodoAuthentication authenticate(TodoAuthentication authentication);
}
