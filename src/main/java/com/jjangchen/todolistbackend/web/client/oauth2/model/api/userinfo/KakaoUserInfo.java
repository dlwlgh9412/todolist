package com.jjangchen.todolistbackend.web.client.oauth2.model.api.userinfo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class KakaoUserInfo implements TodoOauth2UserInfo {
    // 회원번호
    @JsonProperty("id")
    private String id;

    // 자동연결설정을 비활성화 한 경우에 존재
    // false: 연결대기상태
    // true: 연결상태
    @JsonProperty("has_signed_up")
    private String hasSignedUp;

    // 서비스 연결완료 시각
    @JsonProperty("connected_at")
    private LocalDateTime connectedAt;

    // 카카오싱크 간편가입을 통해 로그인한 시
    @JsonProperty("synched_at")
    private LocalDateTime synchedAt;

    @JsonProperty("properties")
    private KakaoUserProperties userProperties;

    @JsonProperty("kakao_account")
    private KakaoAccountInfo accountInfo;

    @Getter
    @NoArgsConstructor
    private class KakaoUserProperties implements TodoOauth2UserProperties {
        @JsonProperty("properties.nickname")
        private String nickname;

        @JsonProperty("properties.profile_image")
        private String profileImage;

        @JsonProperty("properties.thumbnail_image")
        private String thumbnailImage;
    }

    @Getter
    @NoArgsConstructor
    private class KakaoAccountInfo implements TodoOauth2AccountInfo {
        // 사용자 프로필정보 제공가능 여부
        @JsonProperty("profile_needs_agreement")
        private Boolean profileNeedsAgreement;

        // 사용자 닉네임 제공가능 여부
        @JsonProperty("profile_nickname_needs_agreement")
        private Boolean profileNicknameNeedsAgreement;

        // 사용자 프로필 사진 제공가능 여부
        @JsonProperty("profile_image_needs_agreement")
        private Boolean profileImageNeedsAgreement;

        // 프로필 정보
        @JsonProperty("profile")
        private KakaoProfile profile;

        // 사용자 카카오계정 이름 제공가능 여부
        @JsonProperty("name_needs_agreement")
        private Boolean nameNeedsAgreement;

        // 카카오 계정이름
        @JsonProperty("name")
        private String name;

        // 사용자 카카오계정 대표이메일 제공가능 여부
        @JsonProperty("email_needs_agreement")
        private Boolean emailNeedsAgreement;

        // 이메일 유효여부
        @JsonProperty("is_email_valid")
        private Boolean isEmailValid;

        // 이메일 인증 여부
        @JsonProperty("is_email_verified")
        private Boolean isEmailVerified;
        // 카카오계정 대표이메일
        @JsonProperty("email")
        private String email;

        @Getter
        @NoArgsConstructor
        private class KakaoProfile {
            @JsonProperty("nickname")
            private String nickname;

            @JsonProperty("thumbnail_image_url")
            private String thumbnailImageUrl;

            @JsonProperty("profile_image_url")
            private String profileImageUrl;

            // 기본프로필 사진 URL 여부
            @JsonProperty("is_default_image")
            private Boolean isDefaultImage;
        }
    }
}
