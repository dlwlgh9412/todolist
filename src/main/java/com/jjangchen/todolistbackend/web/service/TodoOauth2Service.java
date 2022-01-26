package com.jjangchen.todolistbackend.web.service;

import com.jjangchen.todolistbackend.web.client.oauth2.TodoOauth2RestClientResolver;
import com.jjangchen.todolistbackend.web.client.oauth2.TodoOauth2RestClientStrategy;
import com.jjangchen.todolistbackend.web.client.oauth2.model.TodoSocialRequestAuthorization;
import com.jjangchen.todolistbackend.web.client.oauth2.model.token.TodoSocialTokenResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class TodoOauth2Service {
    private final TodoAccountService accountService;
    private final TodoOauth2RestClientResolver todoOauth2RestClientResolver;
    private TodoOauth2RestClientStrategy restClient;

    public void attemptLogin(TodoSocialRequestAuthorization authorization) {
        TodoSocialTokenResponse token = requestSocialToken(authorization);
    }

    private void validToken

    private TodoSocialTokenResponse requestSocialToken(TodoSocialRequestAuthorization authorization) {
        restClient = todoOauth2RestClientResolver.resolve(authorization.getSocial());
        return restClient.loadToken(authorization.getCode());
    }

    public void expireSocialToken() {
        restClient = todoOauth2RestClientResolver.resolve();
    }
}
