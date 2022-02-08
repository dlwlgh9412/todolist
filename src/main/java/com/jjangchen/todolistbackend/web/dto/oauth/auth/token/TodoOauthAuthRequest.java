package com.jjangchen.todolistbackend.web.dto.oauth.auth.token;

import com.jjangchen.todolistbackend.enums.TodoOauthType;
import org.springframework.util.MultiValueMap;

public interface TodoOauthAuthRequest {
    TodoOauthType getOauthType();
    String getAuthCode();
    MultiValueMap<String, String> getParams();
}
