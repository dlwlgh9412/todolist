package com.jjangchen.todolistbackend.web.client.oauth;

import com.jjangchen.todolistbackend.enums.TodoOauthType;
import com.jjangchen.todolistbackend.web.client.exception.TodoRestClientStrategyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TodoOauthRestClientFactory {
    private final TodoKakaoRestClient kakaoRestClient;
    private final TodoNaverRestClient naverRestClient;

    public TodoOauthRestClientFactory(TodoKakaoRestClient kakaoRestClient, TodoNaverRestClient naverRestClient) {
        this.kakaoRestClient = kakaoRestClient;
        this.naverRestClient = naverRestClient;
    }

    protected TodoOauthRestClient getInstanceByOauthType(TodoOauthType oauthType) {
        final TodoOauthRestClient oauthRestClient;
        switch (oauthType) {
            case KAKAO -> {
                oauthRestClient = kakaoRestClient;
                break;
            }
            case NAVER -> {
                oauthRestClient = naverRestClient;
                break;
            }
            default -> {
                throw new TodoRestClientStrategyException();
            }
        }

        return oauthRestClient;
    }
}
