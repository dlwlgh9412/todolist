package com.jjangchen.todolistbackend.web.client.oauth2;

import com.jjangchen.todolistbackend.enums.TodoSocialType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class TodoAbstractOauth2RestClientStrategy implements TodoOauth2RestClientStrategy {
    protected abstract boolean isSupport(TodoSocialType socialType);
}
