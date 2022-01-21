package com.jjangchen.todolistbackend.web.filter;

import com.jjangchen.todolistbackend.web.aop.authentication.TodoAuthentication;
import com.jjangchen.todolistbackend.web.aop.authentication.converter.TodoAuthenticationConverter;
import com.jjangchen.todolistbackend.web.aop.authentication.converter.TodoAuthenticationConverterResolver;
import com.jjangchen.todolistbackend.web.aop.authentication.manager.TodoAuthenticationManger;
import com.jjangchen.todolistbackend.web.aop.authentication.context.TodoAuthenticationContext;
import com.jjangchen.todolistbackend.web.aop.authentication.context.TodoAuthenticationContextHolder;
import com.jjangchen.todolistbackend.web.aop.authentication.context.TodoAuthenticationContextImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 스프링 시큐리티의 사용자 인증과정을 간단하게 구현
 */

@Slf4j
@RequiredArgsConstructor
@Component
public class TodoAuthenticationFilter extends OncePerRequestFilter {
    private final TodoAuthenticationConverterResolver converterResolver;

    private final TodoAuthenticationManger authenticationManger;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        TodoAuthentication authentication = attemptAuthenticate(request);
        if (authentication == null) {
            filterChain.doFilter(request, response);
            return;
        }
        successAuthenticate(authentication);
        filterChain.doFilter(request, response);
        TodoAuthenticationContextHolder.clearContext();
    }

    private void successAuthenticate(TodoAuthentication authentication) {
        if(authentication.isAuthenticated()) {
            TodoAuthenticationContext authenticationContext = new TodoAuthenticationContextImpl(authentication);
            TodoAuthenticationContextHolder.setContext(authenticationContext);
        }
    }

    private TodoAuthentication attemptAuthenticate(HttpServletRequest request) {
        TodoAuthenticationConverter converter = converterResolver.resolve(request);
        if(converter == null)
            return null;
        TodoAuthentication authentication = converter.convert(request);
        if (authentication == null)
            return null;

        TodoAuthentication result = authenticationManger.authenticate(authentication);
        return result;
    }
}
