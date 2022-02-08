package com.jjangchen.todolistbackend.web.controller;

import com.jjangchen.todolistbackend.web.dto.TodoOauthRequestAuthorization;
import com.jjangchen.todolistbackend.web.service.TodoOauthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/oauth")
public class TodoOauthController {
    private final TodoOauthService socialService;

    /**
     * 클라이언트가 해당 리소스서버로 로그인을 진행한 후 받게되는 인가코드로 토큰요청을 하는 컨트롤러
     * @param authorization
     * @return JwtToken
     */
    @PostMapping("/login")
    public ResponseEntity loadToken(@RequestBody TodoOauthRequestAuthorization authorization) {
        //socialService.attemptLogin(authorization);
        return null;
    }

    /**
     * 클라이언트가 해당 리소스서버 로그아웃을 진행한 후 어플리케이션에서 발급한 액세스토큰 만료
     */
    @DeleteMapping("/logout")
    public void expireToken() {

    }
}