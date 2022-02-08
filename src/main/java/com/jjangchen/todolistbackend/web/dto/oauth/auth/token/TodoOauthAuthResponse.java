package com.jjangchen.todolistbackend.web.dto.oauth.auth.token;

public interface TodoOauthAuthResponse {
    String getTokenType();
    String getAccessToken();
    String getRefreshToken();
    Integer getAccessTokenExpiresIn();
    Integer getRefreshTokenExpiresIn();
    String getScope();
}
