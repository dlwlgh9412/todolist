package com.jjangchen.todolistbackend.web.controller;

import com.jjangchen.todolistbackend.web.client.oauth2.model.TodoSocialRequestAuthorization;
import com.jjangchen.todolistbackend.web.service.TodoOauth2Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/oauth2")
public class TodoOauth2Controller {
    private final TodoOauth2Service socialService;

    /**
     * 클라이언트가 해당 리소스서버로 로그인을 진행한 후 받게되는 인가코드로 토큰요청을 하는 컨트롤러
     * @param authorization
     * @return
     */
    @PostMapping("/login")
    public TodoSocialRequestAuthorization loadToken(TodoSocialRequestAuthorization authorization) {
        socialService.attemptLogin(authorization);
        // 임시 리턴 값
        return authorization;
    }

    /**
     * 클라이언트가 해당 리소스서버 로그아웃을 진행한 후 어플리케이션에서 발급한 JWT토큰으로 어플리케이션
     */
}