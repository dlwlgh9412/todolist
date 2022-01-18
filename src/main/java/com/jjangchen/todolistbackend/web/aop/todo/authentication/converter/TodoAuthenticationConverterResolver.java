package com.jjangchen.todolistbackend.web.aop.todo.authentication.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

@RequiredArgsConstructor
@Component
public class TodoAuthenticationConverterResolver {
    private final List<TodoAuthenticationConverter> converters;
    private final String prefix = "todo";

    public TodoAuthenticationConverter resolve(HttpServletRequest request) {
        Assert.notNull(converters, "컨버터 리스트는 null이 될 수 없습니다.");

        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()) {
            String header = enumeration.nextElement();
            if(!header.startsWith(prefix))
                continue;

            for (TodoAuthenticationConverter converter : converters) {
                if (converter.getHeader().equals(header))
                    return converter;
            }
        }

        throw new TodoAuthenticationResolverException("인증헤더를 확인해주세요.");
    }
}
