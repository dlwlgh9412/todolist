package com.jjangchen.todolistbackend.web.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
@EnableConfigurationProperties
@PropertySource("classpath:properties/${spring.profiles.active}/social-parameter.properties")
public class SocialParameterProperties {
    @Value("${kakao.grant.type}")
    private String kakaoGrantType;

    @Value("${kakao.rest.api.key}")
    private String kakaoRestApiKey;

    @Value("${kakao.redirect.uri}")
    private String kakaoRedirectUrl;

    @Value("${kakao.client.secret}")
    private String kakaoClientSecret;
}
