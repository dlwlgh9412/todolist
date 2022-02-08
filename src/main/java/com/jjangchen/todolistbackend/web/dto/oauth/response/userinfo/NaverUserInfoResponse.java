package com.jjangchen.todolistbackend.web.dto.oauth.response.userinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public abstract class NaverUserInfoResponse implements TodoOauthUserInfoResponse {
    @JsonProperty("resultcode")
    private String resultCode;

    @JsonProperty("message")
    private String message;

    @Getter
    @NoArgsConstructor
    private class naverResponse extends NaverUserInfoResponse {
        @JsonProperty("email")
        private String email;

        @JsonProperty("nickname")
        private String nickname;

        @JsonProperty("profile_image")
        private String profileImageUrl;

        @JsonProperty("id")
        private Long id;
    }
}
