package com.jjangchen.todolistbackend.web.controller;

import com.jjangchen.todolistbackend.web.service.TodoAccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/oauth")
public class TodoSocialController {
    private final TodoAccountService accountService;

    @PostMapping("/token")
    public void loadToke(HttpServletRequest request) {
        String authorizeCode = request.getHeader("Authorize");
        log.info(authorizeCode);
    }
}
