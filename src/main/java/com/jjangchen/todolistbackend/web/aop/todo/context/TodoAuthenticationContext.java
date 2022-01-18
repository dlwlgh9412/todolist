package com.jjangchen.todolistbackend.web.aop.todo.context;

import com.jjangchen.todolistbackend.web.aop.todo.authentication.TodoAuthentication;

public interface TodoAuthenticationContext {
    TodoAuthentication getTodoAuthentication();
    void setTodoAuthentication(TodoAuthentication authentication);
}
