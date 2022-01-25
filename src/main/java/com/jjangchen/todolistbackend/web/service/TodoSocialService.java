package com.jjangchen.todolistbackend.web.service;

import com.jjangchen.todolistbackend.web.client.social.TodoSocialRestClientResolver;
import com.jjangchen.todolistbackend.web.client.social.TodoSocialRestClientStrategy;
import com.jjangchen.todolistbackend.web.client.social.model.TodoSocialRequestAuthorization;
import com.jjangchen.todolistbackend.web.client.social.model.token.TodoSocialTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class TodoSocialService {
    private final TodoAccountService accountService;
    private final TodoSocialRestClientResolver todoSocialRestClientResolver;
    private TodoSocialRestClientStrategy restClient;

    public void attemptLogin(TodoSocialRequestAuthorization authorization) {
        TodoSocialTokenResponse token = loadToken(authorization);
    }

    private TodoSocialTokenResponse loadToken(TodoSocialRequestAuthorization authorization) {
        restClient = todoSocialRestClientResolver.resolve(authorization.getSocial());
        return restClient.loadToken(authorization.getCode());

    }
}
