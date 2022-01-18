package com.jjangchen.todolistbackend.web.resolver;

import com.jjangchen.todolistbackend.entity.TodoAccount;
import com.jjangchen.todolistbackend.repository.TodoAccountRepository;
import com.jjangchen.todolistbackend.web.dto.TodoSaveDto;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class AuthenticationResolver implements HandlerMethodArgumentResolver {
    private final String AUTHENTICATION_HEADER = "Authentication";
    private final TodoAccountRepository todoAccountRepository;

    public AuthenticationResolver(TodoAccountRepository todoAccountRepository) {
        this.todoAccountRepository = todoAccountRepository;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        System.out.println(parameter.getParameterType());
        return parameter.hasParameterAnnotation(RequestBody.class) && parameter.getParameterType() == TodoSaveDto.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String nickname = webRequest.getHeader(AUTHENTICATION_HEADER);
        TodoAccount todoAccount = todoAccountRepository.findByUsername(nickname).orElseThrow();
        System.out.println(parameter.getParameterType());
        return null;
    }
}
