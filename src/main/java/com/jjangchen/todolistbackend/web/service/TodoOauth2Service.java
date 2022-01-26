package com.jjangchen.todolistbackend.web.service;

import com.jjangchen.todolistbackend.web.client.oauth2.TodoOauth2RestClientResolver;
import com.jjangchen.todolistbackend.web.client.oauth2.TodoOauth2RestClientStrategy;
import com.jjangchen.todolistbackend.web.client.oauth2.model.TodoOauth2RequestAuthorization;
import com.jjangchen.todolistbackend.web.client.oauth2.model.auth.token.TodoOauth2Token;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class TodoOauth2Service {
    private final TodoAccountService accountService;
    private final TodoOauth2RestClientResolver todoOauth2RestClientResolver;
    private TodoOauth2RestClientStrategy restClient;

    public void attemptLogin(TodoOauth2RequestAuthorization authorization) {
        TodoOauth2Token token = requestSocialToken(authorization);
    }

    private TodoOauth2Token requestSocialToken(TodoOauth2RequestAuthorization authorization) {
        restClient = todoOauth2RestClientResolver.resolve(authorization.getSocial());
        return restClient.loadToken(authorization.getCode());
    }


}
