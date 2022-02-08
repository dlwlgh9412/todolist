package com.jjangchen.todolistbackend.web.client.oauth;

import com.jjangchen.todolistbackend.enums.TodoOauthType;
import com.jjangchen.todolistbackend.exception.TodoSocialTypeException;
import com.jjangchen.todolistbackend.web.client.exception.TodoRestClientStrategyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Factory클래스 사용으로 인해 미사용
 */
@RequiredArgsConstructor
@Component
public class TodoOauthRestClientResolver {
    private final List<TodoAbstractOauthRestClient> restClientList;

    public TodoAbstractOauthRestClient resolve(TodoOauthType socialType) {
        if(socialType == null)
            throw new TodoSocialTypeException();

        for(TodoAbstractOauthRestClient restClient : restClientList) {
            restClient.isSupport(socialType);
            return restClient;
        }
        throw new TodoRestClientStrategyException();
    }
}
