package com.jjangchen.todolistbackend.web.client.oauth2;

import com.jjangchen.todolistbackend.enums.TodoSocialType;
import com.jjangchen.todolistbackend.web.client.oauth2.model.token.TodoSocialTokenResponse;
import org.springframework.stereotype.Component;

@Component
public class TodoNaverRestClientStrategy extends TodoAbstractOauth2RestClientStrategy {

    @Override
    public boolean isSupport(TodoSocialType socialType) {
        return TodoSocialType.NAVER.equals(socialType);
    }

    @Override
    public TodoSocialTokenResponse loadToken(String code) {
        return null;
    }
}
