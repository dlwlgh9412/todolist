package com.jjangchen.todolistbackend.web.properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@Getter
@EnableConfigurationProperties
@PropertySource("classpath:properties/${spring.profiles.active}/oauth-auth-parameter.properties")
public class KakaoTokenParameter {
    @JsonProperty("grant_type")
    @Value("${kakao.grant_type}")
    private String grantType;

    @JsonProperty("client_id")
    @Value("${kakao.client_id}")
    private String clientId;

    @JsonProperty("redirect_uri")
    @Value("${kakao.redirect_uri")
    private String redirectUri;

    @JsonProperty("client_secret")
    @Value("${kakao.client_secret}")
    private String clientSecret;
}
