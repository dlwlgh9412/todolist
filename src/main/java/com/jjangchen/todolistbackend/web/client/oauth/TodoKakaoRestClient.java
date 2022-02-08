package com.jjangchen.todolistbackend.web.client.oauth;

import com.jjangchen.todolistbackend.enums.TodoOauthType;
import com.jjangchen.todolistbackend.web.client.exception.TodoRestClientStrategyException;
import com.jjangchen.todolistbackend.web.dto.oauth.auth.token.TodoOauthAuthRequest;
import com.jjangchen.todolistbackend.web.dto.oauth.auth.token.TodoKakaoAuthResponse;
import com.jjangchen.todolistbackend.web.dto.oauth.auth.token.TodoOauthAuthResponse;
import com.jjangchen.todolistbackend.web.dto.oauth.response.userinfo.KakaoUserInfoResponse;
import com.jjangchen.todolistbackend.web.dto.oauth.response.userinfo.TodoOauthUserInfoResponse;
import com.jjangchen.todolistbackend.web.properties.OauthApiParameterProperties;
import com.jjangchen.todolistbackend.web.properties.KakaoTokenParameter;
import com.jjangchen.todolistbackend.web.properties.UrlProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Slf4j
@Component
public class TodoKakaoRestClient extends TodoAbstractOauthRestClient {
    private final WebClient authClient;
    private final WebClient apiClient;
    private final KakaoTokenParameter authParameterProperties;
    private final OauthApiParameterProperties apiParameterProperties;

    public TodoKakaoRestClient(UrlProperties urlProperties, KakaoTokenParameter authParameterProperties, OauthApiParameterProperties apiParameterProperties) {
        this.authClient = WebClient.builder().baseUrl(urlProperties.getKakaoAuthBaseUrl()).build();
        this.apiClient = WebClient.builder().baseUrl(urlProperties.getKakaoApiBaseUrl()).build();
        this.authParameterProperties = authParameterProperties;
        this.apiParameterProperties = apiParameterProperties;
    }

    @Override
    public boolean isSupport(TodoOauthType socialType) {
        return TodoOauthType.KAKAO.equals(socialType);
    }

    @Override
    public TodoOauthAuthResponse getAccessToken(TodoOauthAuthRequest oauthRequest) {
        try {
            return authClient.post()
                    .uri(uriBuilder -> uriBuilder.path("/token")
                            .queryParams(oauthRequest.getParams())
                            .build())
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .retrieve().bodyToMono(TodoKakaoAuthResponse.class).block();
        } catch (WebClientResponseException e) {
            log.error(e.getResponseBodyAsString());
            throw new TodoRestClientStrategyException();
        }
    }

    @Override
    public TodoOauthUserInfoResponse getUserInfo(TodoOauthAuthRequest oauthRequest) {
        TodoOauthUserInfoResponse userInfo = null;
        try {
            userInfo = apiClient.post()
                    .uri(uriBuilder -> uriBuilder.path("/v2/user/me")
                            .queryParams(oauthRequest.getParams())
                            .build())
                    .header(null)
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .retrieve().bodyToMono(KakaoUserInfoResponse.class).block();
        } catch (WebClientResponseException e) {
            log.error(e.getResponseBodyAsString());
        }
        return userInfo;
    }

}
