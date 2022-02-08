package com.jjangchen.todolistbackend.web.resolver;

import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
public class TodoOauthRequestMethodArgumentResolver {

/*    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType() == TodoOauthTokenRequest.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        return convertToTokenRequest(request);
    }


    private TodoOauthTokenRequest convertToTokenRequest(HttpServletRequest request) {
        return null;
    }*/
}
