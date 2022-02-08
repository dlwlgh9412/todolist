package com.jjangchen.todolistbackend.web.client.oauth;

import com.jjangchen.todolistbackend.enums.TodoOauthType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class TodoAbstractOauthRestClient implements TodoOauthRestClient {
    protected abstract boolean isSupport(TodoOauthType socialType);
}
