package com.jjangchen.todolistbackend.web.client.social;

import com.jjangchen.todolistbackend.enums.TodoSocialType;
import com.jjangchen.todolistbackend.web.client.social.model.token.TodoSocialTokenResponse;
import org.springframework.stereotype.Component;

@Component
public class TodoNaverRestClientStrategy extends TodoAbstractSocialRestClientStrategy {

    @Override
    public boolean isSupport(TodoSocialType socialType) {
        return TodoSocialType.NAVER.equals(socialType);
    }

    @Override
    public TodoSocialTokenResponse loadToken(String code) {
        return null;
    }
}
