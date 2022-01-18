package com.jjangchen.todolistbackend.web.aop.todo.authentication.converter;

import com.jjangchen.todolistbackend.web.aop.todo.authentication.TodoAuthentication;
import com.jjangchen.todolistbackend.web.aop.todo.authentication.TodoUserAuthentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class TodoUserAuthenticationConverter implements TodoAuthenticationConverter {
    private final TodoAuthenticationHeaderList header = TodoAuthenticationHeaderList.DEFAULT;

    @Override
    public TodoAuthentication convert(HttpServletRequest request) {
        String principal = request.getHeader(this.getHeader());
        if(principal.equals("") || principal == null)
            return null;
        return new TodoUserAuthentication(principal);
    }

    @Override
    public String getHeader() {
        return this.header.value;
    }
}
