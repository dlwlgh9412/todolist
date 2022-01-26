package com.jjangchen.todolistbackend.web.client.oauth2.model.auth.token;

public interface TodoOauth2Token {
    String getTokenType();
    String getAccessToken();
    String getRefreshToken();
    Integer getAccessTokenExpiresIn();
    Integer getRefreshTokenExpiresIn();
    String getScope();
}
