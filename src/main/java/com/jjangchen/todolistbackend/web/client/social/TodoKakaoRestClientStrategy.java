package com.jjangchen.todolistbackend.web.client.social;

import com.jjangchen.todolistbackend.enums.TodoSocialType;
import com.jjangchen.todolistbackend.web.client.social.model.token.TodoKakaoTokenResponse;
import com.jjangchen.todolistbackend.web.client.social.model.token.TodoSocialTokenResponse;
import com.jjangchen.todolistbackend.web.properties.SocialParameterProperties;
import com.jjangchen.todolistbackend.web.properties.UrlProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Slf4j
@Component
public class TodoKakaoRestClientStrategy extends TodoAbstractSocialRestClientStrategy {
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
    public TodoSocialTokenResponse loadToken(String code) {
        TodoKakaoTokenResponse token = null;
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
                    .retrieve().bodyToMono(TodoKakaoTokenResponse.class).block();
        } catch (WebClientResponseException e) {
            log.error(e.getResponseBodyAsString());
        }
        return token;
    }
}
