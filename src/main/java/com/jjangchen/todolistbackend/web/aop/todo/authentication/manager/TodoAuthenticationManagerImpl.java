package com.jjangchen.todolistbackend.web.aop.todo.authentication.manager;

import com.jjangchen.todolistbackend.web.aop.todo.authentication.TodoAuthentication;
import com.jjangchen.todolistbackend.web.aop.todo.authentication.provider.TodoAuthenticationProvider;
import com.jjangchen.todolistbackend.web.aop.todo.exception.NotMatchTodoAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TodoAuthenticationManagerImpl implements TodoAuthenticationManger {
    private final List<TodoAuthenticationProvider> providers;

    @Override
    public TodoAuthentication authenticate(TodoAuthentication authentication) {
        for(TodoAuthenticationProvider provider : providers) {
            if(!provider.isSupport(authentication.getClass()))
                continue;

            return provider.authenticate(authentication);
        }

        throw new NotMatchTodoAuthenticationProvider("해당 인증정보를 검증할 인증 제공자가 없습니다.");
    }
}
