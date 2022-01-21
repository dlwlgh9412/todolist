package com.jjangchen.todolistbackend.web.aop.authentication.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TodoAuthenticationConverterResolverImpl<T> implements TodoAuthenticationConverterResolver<T> {
    private final List<TodoAuthenticationConverter> converters;

    public TodoAuthenticationConverter resolve(T type) {
        Assert.notNull(converters, "컨버터 리스트는 null이 될 수 없습니다.");
        for (TodoAuthenticationConverter converter : converters) {
            if (converter.isSupport(type.getClass()))
                return converter;
        }

        throw new TodoAuthenticationResolverException("인증헤더를 확인해주세요.");
    }
}
