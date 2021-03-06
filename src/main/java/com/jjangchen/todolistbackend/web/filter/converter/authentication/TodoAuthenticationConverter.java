package com.jjangchen.todolistbackend.web.filter.converter.authentication;

import com.jjangchen.todolistbackend.web.aop.authentication.TodoAuthentication;

import javax.servlet.http.HttpServletRequest;

public interface TodoAuthenticationConverter {
    TodoAuthentication convert(HttpServletRequest request);
    String getHeader();

    boolean isSupport(Class<?> type);
}
