package com.jjangchen.todolistbackend.web.client.social.model;

import com.jjangchen.todolistbackend.enums.TodoSocialType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TodoSocialRequestAuthorization {
    private final TodoSocialType social;
    private final String code;
}
