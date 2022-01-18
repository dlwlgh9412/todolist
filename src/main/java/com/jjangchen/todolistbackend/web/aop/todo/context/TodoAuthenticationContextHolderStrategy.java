package com.jjangchen.todolistbackend.web.aop.todo.context;

public interface TodoAuthenticationContextHolderStrategy {
    void clearContext();
    TodoAuthenticationContext getContext();
    void setContext(TodoAuthenticationContext context);
    TodoAuthenticationContext createEmptyContext();
}
