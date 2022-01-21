package com.jjangchen.todolistbackend.web.aop.authentication.context;

import com.jjangchen.todolistbackend.web.aop.authentication.TodoAuthentication;

public interface TodoAuthenticationContext {
    TodoAuthentication getTodoAuthentication();
    void setTodoAuthentication(TodoAuthentication authentication);
}
