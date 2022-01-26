package com.jjangchen.todolistbackend.web.client.oauth2;

import com.jjangchen.todolistbackend.web.client.oauth2.model.auth.token.TodoOauth2Token;

public interface TodoOauth2RestClientStrategy {
    TodoOauth2Token loadToken(String code);
}
