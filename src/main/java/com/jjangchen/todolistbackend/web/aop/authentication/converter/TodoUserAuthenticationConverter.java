package com.jjangchen.todolistbackend.web.aop.authentication.converter;

import com.jjangchen.todolistbackend.web.aop.authentication.TodoAuthentication;
import com.jjangchen.todolistbackend.web.aop.authentication.TodoUserAuthentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class TodoUserAuthenticationConverter implements TodoAuthenticationConverter {
    private final TodoAuthenticationHeaderType header = TodoAuthenticationHeaderType.DEFAULT;

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

    @Override
    public boolean isSupport(Class<?> type) {
        return HttpServletRequest.class.isAssignableFrom(type);
    }
}
