package com.jjangchen.todolistbackend.web.client.oauth2.model.token;

public interface TodoSocialTokenResponse {
    String getTokenType();
    String getAccessToken();
    String getRefreshToken();
    Integer getAccessTokenExpiresIn();
    Integer getRefreshTokenExpiresIn();
    String getScope();
}
