package com.jjangchen.todolistbackend.web.client.social;

import com.jjangchen.todolistbackend.web.client.social.model.token.TodoSocialTokenResponse;

public interface TodoSocialRestClientStrategy {
    TodoSocialTokenResponse loadToken(String code);
}
