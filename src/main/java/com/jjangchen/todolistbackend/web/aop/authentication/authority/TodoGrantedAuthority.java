package com.jjangchen.todolistbackend.web.aop.authentication.authority;

public interface TodoGrantedAuthority {
    TodoAuthorityEnum getAuthority();
}
