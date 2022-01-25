package com.jjangchen.todolistbackend.web.controller;

import com.jjangchen.todolistbackend.web.client.social.model.TodoSocialRequestAuthorization;
import com.jjangchen.todolistbackend.web.service.TodoSocialService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/social")
public class TodoSocialController {
    private final TodoSocialService socialService;

    @PostMapping("/login")
    public TodoSocialRequestAuthorization loadToken(TodoSocialRequestAuthorization authorization) {
        socialService.attemptLogin(authorization);
        return authorization;
    }
}