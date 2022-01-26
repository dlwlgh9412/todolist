package com.jjangchen.todolistbackend.web.resolver;

import com.jjangchen.todolistbackend.enums.TodoSocialType;
import com.jjangchen.todolistbackend.web.client.oauth2.model.TodoOauth2RequestAuthorization;
import com.jjangchen.todolistbackend.web.client.oauth2.model.TodoOauth2RequestSeparator;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

@RequiredArgsConstructor
public class TodoOauth2MethodArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType() == TodoOauth2RequestAuthorization.class;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        return convertToSocialAuthorization(request);
    }


    private TodoOauth2RequestAuthorization convertToSocialAuthorization(HttpServletRequest request) {
        String authorization = request.getHeader("Authorization");
        String[] result = authorization.split(TodoOauth2RequestSeparator.UNDER_BAR.getSeparator());
        return new TodoOauth2RequestAuthorization(TodoSocialType.valueOf(result[0].toUpperCase(Locale.ROOT)), result[1]);
    }
}
