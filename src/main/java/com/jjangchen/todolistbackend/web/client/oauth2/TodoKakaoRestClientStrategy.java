package com.jjangchen.todolistbackend.web.client.oauth2;

import com.jjangchen.todolistbackend.enums.TodoSocialType;
import com.jjangchen.todolistbackend.web.client.oauth2.model.auth.token.KakaoToken;
import com.jjangchen.todolistbackend.web.client.oauth2.model.auth.token.TodoOauth2Token;
import com.jjangchen.todolistbackend.web.properties.SocialParameterProperties;
import com.jjangchen.todolistbackend.web.properties.UrlProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Slf4j
@Component
public class TodoKakaoRestClientStrategy extends TodoAbstractOauth2RestClientStrategy {
    private final WebClient authClient;
    private final WebClient apiClient;
    private final SocialParameterProperties parameterProperties;

    public TodoKakaoRestClientStrategy(UrlProperties urlProperties, SocialParameterProperties parameterProperties) {
        authClient = WebClient.builder().baseUrl(urlProperties.getKakaoAuthBaseUrl()).build();
        apiClient = WebClient.builder().baseUrl(urlProperties.getKakaoApiBaseUrl()).build();
        this.parameterProperties = parameterProperties;
    }

    @Override
    public boolean isSupport(TodoSocialType socialType) {
        return TodoSocialType.KAKAO.equals(socialType);
    }

    @Override
    public TodoOauth2Token loadToken(String code) {
        KakaoToken token = null;
        try {
            token = authClient.post()
                    .uri(uriBuilder -> uriBuilder.path("/oauth/token")
                            .queryParam("grant_type", parameterProperties.getKakaoGrantType())
                            .queryParam("client_id", parameterProperties.getKakaoRestApiKey())
                            .queryParam("redirect_uri", parameterProperties.getKakaoRedirectUrl())
                            .queryParam("code", code)
                            .queryParam("client_secret", parameterProperties.getKakaoClientSecret())
                            .build())
                    .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                    .retrieve().bodyToMono(KakaoToken.class).block();
        } catch (WebClientResponseException e) {
            log.error(e.getResponseBodyAsString());
        }
        return token;
    }
}
