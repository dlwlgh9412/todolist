package com.jjangchen.todolistbackend.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjangchen.todolistbackend.util.MultiValueMapConverter;
import com.jjangchen.todolistbackend.web.dto.oauth.auth.token.TodoKakaoTokenRequest;
import com.jjangchen.todolistbackend.web.properties.KakaoTokenParameter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.MultiValueMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class KakaoTokenParameterTest {
    @Autowired
    KakaoTokenParameter kakaoTokenParameter;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void test() {
        String grantType = "[authorization_code]";
        String client_id = "ad35a8c1867f86adc6e2d3d3b25b47c2";
        String redirectUri = "http://localhost:8080/oauth/kakao";
        String clientSecret = "AdCrsSHZqmEoURiIpuGdLbLuZSvvU2Gn";

        //when
        TodoKakaoTokenRequest dto = TodoKakaoTokenRequest.builder()
                .grantType(kakaoTokenParameter.getGrantType())
                .clientId(kakaoTokenParameter.getClientId())
                .redirectUri(kakaoTokenParameter.getRedirectUri())
                .clientSecret(kakaoTokenParameter.getClientSecret())
                .build();
        MultiValueMap<String, String> params = MultiValueMapConverter.convert(objectMapper, dto);

    }
}
