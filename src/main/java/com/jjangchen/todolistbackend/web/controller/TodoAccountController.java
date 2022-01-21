package com.jjangchen.todolistbackend.web.controller;

import com.jjangchen.todolistbackend.web.service.TodoAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class TodoAccountController {
    private final TodoAccountService accountService;

    @PostMapping
    public String createUser(HttpServletRequest request) {
        String username = request.getHeader("Username");
        return accountService.createAccount(username);
    }

    @DeleteMapping
    public void deleteUser() {
        accountService.deleteAccount();
    }
}
