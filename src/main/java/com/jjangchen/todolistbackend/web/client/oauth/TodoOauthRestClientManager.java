package com.jjangchen.todolistbackend.web.client.oauth;

import com.jjangchen.todolistbackend.enums.TodoOauthType;
import com.jjangchen.todolistbackend.web.dto.oauth.auth.token.TodoOauthAuthRequest;
import com.jjangchen.todolistbackend.web.dto.oauth.auth.token.TodoOauthAuthResponse;
import org.springframework.stereotype.Component;

@Component
public class TodoOauthRestClientManager {
    private final TodoOauthRestClientFactory todoOauthRestClientFactory;

    public TodoOauthRestClientManager(TodoOauthRestClientFactory todoOauthRestClientFactory) {
        this.todoOauthRestClientFactory = todoOauthRestClientFactory;
    }

    public TodoOauthAuthResponse getAccessToken(TodoOauthAuthRequest oauthRequest) {
        final TodoOauthType oauthType = oauthRequest.getOauthType();

        TodoOauthRestClient restClient = getOauthRestClientInstance(oauthType);
        return restClient.getAccessToken(oauthRequest);
    }

/*    public void getUserInfo(TodoOauthAuthRequest oauthRequest) {
        final TodoOauthType oauthType = oauthRequest.getOauthType();

        TodoOauthRestClient restClient = getOauthRestClientInstance(oauthType);
        String accessToken = oauthRequest.getAccessToken();
    }*/

    public TodoOauthRestClient getOauthRestClientInstance(TodoOauthType oauthType) {
        return todoOauthRestClientFactory.getInstanceByOauthType(oauthType);
    }
}
