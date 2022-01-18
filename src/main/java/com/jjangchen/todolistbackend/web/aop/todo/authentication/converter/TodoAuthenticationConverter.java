package com.jjangchen.todolistbackend.web.aop.todo.authentication.converter;

import com.jjangchen.todolistbackend.web.aop.todo.authentication.TodoAuthentication;

import javax.servlet.http.HttpServletRequest;

public interface TodoAuthenticationConverter {
    TodoAuthentication convert(HttpServletRequest request);
    String getHeader();
}
