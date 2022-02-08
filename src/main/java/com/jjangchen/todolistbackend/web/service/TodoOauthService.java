package com.jjangchen.todolistbackend.web.service;

import com.jjangchen.todolistbackend.entity.TodoAccount;
import com.jjangchen.todolistbackend.exception.TodoAccountNotFoundException;
import com.jjangchen.todolistbackend.web.client.oauth.TodoOauthRestClientManager;
import com.jjangchen.todolistbackend.web.dto.oauth.OauthLoginInfo;
import com.jjangchen.todolistbackend.web.dto.oauth.auth.token.TodoOauthAuthRequest;
import com.jjangchen.todolistbackend.web.dto.oauth.response.userinfo.TodoOauthUserInfoResponse;
import com.jjangchen.todolistbackend.web.client.oauth.TodoOauthRestClientResolver;
import com.jjangchen.todolistbackend.web.client.oauth.TodoOauthRestClient;
import com.jjangchen.todolistbackend.web.dto.TodoOauthRequestAuthorization;
import com.jjangchen.todolistbackend.web.dto.oauth.auth.token.TodoOauthAuthResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class TodoOauthService {
    private final TodoAccountService accountService;
    private final TodoOauthRestClientResolver todoOauthRestClientResolver;
    private TodoOauthRestClient restClient;
    private final TodoOauthRestClientManager restClientManager;

    public void attemptLogin(OauthLoginInfo loginInfo) {
        /*TodoOauthAuthResponse tokenResponse = getAccessToken(authorization);
        TodoOauthUserInfoResponse userInfo = getOauthUserInfo(tokenResponse);
        TodoAccount todoAccount = accountService.loadUser(userInfo.getId(), authorization.getSocial()).orElseThrow(TodoAccountNotFoundException::new);*/
    }

    /*
    private void resolveRestClientStrategy(TodoOauthType socialType) {
        restClient = todoOauthRestClientResolver.resolve(socialType);
    }
     */

/*    private TodoOauthAuthResponse getAccessToken(OauthLoginInfo loginInfo) {
        TodoOauthAuthRequest request = assembleOauthRequest();
        return restClientManager.getAccessToken(request);
    }

    private TodoOauthUserInfoResponse getOauthUserInfo(TodoOauthAuthResponse tokenResponse) {
        return restClient.getUserInfo(tokenResponse.getAccessToken());
    }

    private TodoOauthAuthRequest assembleOauthRequest(TodoOauthRequestAuthorization authorization) {

    }*/
}
