package com.jjangchen.todolistbackend.web.resolver;

import com.jjangchen.todolistbackend.entity.TodoAccount;
import com.jjangchen.todolistbackend.web.dto.TodoRequestDto;
import com.jjangchen.todolistbackend.web.service.TodoAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@RequiredArgsConstructor
public class TodoRequestMethodArgumentResolver implements HandlerMethodArgumentResolver {
    private final TodoAccountService accountService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType() == TodoRequestDto.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        TodoRequestDto dto = (TodoRequestDto) parameter;
        dto.setUser(loadAccount());
        return dto;
    }

    private TodoAccount loadAccount() {
        return accountService.loadAccountByContext();
    }
}
