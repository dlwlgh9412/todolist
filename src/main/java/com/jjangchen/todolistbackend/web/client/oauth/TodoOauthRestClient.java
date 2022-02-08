package com.jjangchen.todolistbackend.web.client.oauth;

import com.jjangchen.todolistbackend.web.dto.oauth.auth.token.TodoOauthAuthRequest;
import com.jjangchen.todolistbackend.web.dto.oauth.auth.token.TodoOauthAuthResponse;
import com.jjangchen.todolistbackend.web.dto.oauth.response.userinfo.TodoOauthUserInfoResponse;

public interface TodoOauthRestClient {
    TodoOauthAuthResponse getAccessToken(TodoOauthAuthRequest oauthRequest);
    TodoOauthUserInfoResponse getUserInfo(TodoOauthAuthRequest oauthRequest);
}
