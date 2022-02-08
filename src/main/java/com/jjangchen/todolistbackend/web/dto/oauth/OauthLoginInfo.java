package com.jjangchen.todolistbackend.web.dto.oauth;

import com.jjangchen.todolistbackend.enums.TodoOauthType;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class OauthLoginInfo {
    private TodoOauthType oauthType;
    private String code;
}
