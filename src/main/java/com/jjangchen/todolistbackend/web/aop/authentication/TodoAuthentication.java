package com.jjangchen.todolistbackend.web.aop.authentication;

public interface TodoAuthentication extends TodoPrincipal {
    Object getPrincipal();
    boolean isAuthenticated();
    void setAuthenticated(boolean authenticated);
}
