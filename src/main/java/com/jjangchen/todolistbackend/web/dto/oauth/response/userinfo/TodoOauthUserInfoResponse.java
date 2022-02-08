package com.jjangchen.todolistbackend.web.dto.oauth.response.userinfo;

public interface TodoOauthUserInfoResponse {
    Long getId();
    String getNickname();
    String getProfileImageUrl();
    String getEmail();

    // 사용자 프로필 제공가능여부
//    Boolean getProfileNeedsAgreement();
    // 사용자 프로필 닉네임 제공가능여부
//    Boolean getProfileNicknameNeedsAgreement();
    // 사용자 프로필 이미지 제공가능여부
//    Boolean getProfileImageNeedsAgreement();
    // 사용자 이메일 제공가능여부
//    Boolean getEmailNeedsAgreement();
    // 이메일 유효여부
//    Boolean getIsEmailValid();
    // 이메일 인증 여부
//    Boolean getIsEmailVerified();
}
