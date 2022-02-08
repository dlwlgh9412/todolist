package com.jjangchen.todolistbackend.web.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
@EnableConfigurationProperties
@PropertySource("classpath:properties/${spring.profiles.active}/oauth-auth-parameter.properties")
public class NaverTokenParameter {
    @Value("${naver.grant_type}")
    private String grantType;

    @Value("${naver.client_id}")
    private String clientId;

    @Value("${naver.client_secret}")
    private String clientSecret;
}
