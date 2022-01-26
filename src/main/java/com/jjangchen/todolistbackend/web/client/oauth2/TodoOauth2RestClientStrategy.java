package com.jjangchen.todolistbackend.web.client.oauth2;

import com.jjangchen.todolistbackend.web.client.oauth2.model.token.TodoSocialTokenResponse;

public interface TodoOauth2RestClientStrategy {
    TodoSocialTokenResponse loadToken(String code);
}
