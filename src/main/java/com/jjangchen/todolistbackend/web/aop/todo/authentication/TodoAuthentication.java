package com.jjangchen.todolistbackend.web.aop.todo.authentication;

public interface TodoAuthentication extends TodoPrincipal {
    Object getPrincipal();
    boolean isAuthenticated();
    void setAuthenticated(boolean authenticated);
}
