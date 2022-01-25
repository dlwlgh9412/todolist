package com.jjangchen.todolistbackend.web.properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Getter
@EnableConfigurationProperties
@PropertySource("classpath:properties/url.properties")
public class UrlProperties {
    @Value("${kakao.authBaseUrl}")
    private String kakaoAuthBaseUrl;

    @Value("${kakao.apiBaseUrl}")
    private String kakaoApiBaseUrl;

    @Value("${naver.authBaseUrl}")
    private String naverAuthBaseUrl;

    @Value("${naver.apiBaseUrl}")
    private String naverApiBaseUrl;
}
