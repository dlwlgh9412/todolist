package com.jjangchen.todolistbackend.web.client.social;

import com.jjangchen.todolistbackend.enums.TodoSocialType;
import com.jjangchen.todolistbackend.exception.TodoSocialTypeException;
import com.jjangchen.todolistbackend.web.client.exception.TodoRestClientStrategyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TodoSocialRestClientResolver {
    private final List<TodoAbstractSocialRestClientStrategy> restClientList;

    public TodoAbstractSocialRestClientStrategy resolve(TodoSocialType socialType) {
        if(socialType == null)
            throw new TodoSocialTypeException();

        for(TodoAbstractSocialRestClientStrategy restClient : restClientList) {
            restClient.isSupport(socialType);
            return restClient;
        }
        throw new TodoRestClientStrategyException();
    }
}
