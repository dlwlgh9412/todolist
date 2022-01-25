package com.jjangchen.todolistbackend.web.client.social;

import com.jjangchen.todolistbackend.enums.TodoSocialType;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class TodoAbstractSocialRestClientStrategy implements TodoSocialRestClientStrategy {
    protected abstract boolean isSupport(TodoSocialType socialType);
}
