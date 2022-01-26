package com.jjangchen.todolistbackend.web.client.oauth2;

import com.jjangchen.todolistbackend.enums.TodoSocialType;
import com.jjangchen.todolistbackend.exception.TodoSocialTypeException;
import com.jjangchen.todolistbackend.web.client.exception.TodoRestClientStrategyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class TodoOauth2RestClientResolver {
    private final List<TodoAbstractOauth2RestClientStrategy> restClientList;

    public TodoAbstractOauth2RestClientStrategy resolve(TodoSocialType socialType) {
        if(socialType == null)
            throw new TodoSocialTypeException();

        for(TodoAbstractOauth2RestClientStrategy restClient : restClientList) {
            restClient.isSupport(socialType);
            return restClient;
        }
        throw new TodoRestClientStrategyException();
    }
}
