package com.jjangchen.todolistbackend.web.dto;

import com.jjangchen.todolistbackend.enums.TodoOauthType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class TodoOauthRequestAuthorization {

    private TodoOauthType social;
    private String code;
    private String state;
    private String grantType;
}
