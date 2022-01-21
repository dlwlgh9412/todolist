package com.jjangchen.todolistbackend.web.aop.authentication.authority;

import org.springframework.util.Assert;

import java.util.*;

public final class TodoAuthorityUtils {
    public static final List<TodoGrantedAuthority> NO_AUTHORITIES = Collections.emptyList();

    private TodoAuthorityUtils() {
    }

    public static Set<TodoAuthorityEnum> authorityListToSet(Collection<? extends TodoGrantedAuthority> authorities) {
        Assert.notEmpty(authorities, "권한 목록은 null이 될 수 없습니다.");
        Set<TodoAuthorityEnum> todoAuthorityEnumSet = new HashSet<>(authorities.size());
        for (TodoGrantedAuthority authority : authorities) {
            todoAuthorityEnumSet.add(authority.getAuthority());
        }
        return todoAuthorityEnumSet;
    }

    public static List<TodoGrantedAuthority> createAuthorityList(TodoAuthorityEnum... authorityEnums) {
        List<TodoGrantedAuthority> grantedAuthorities = new ArrayList<>(authorityEnums.length);
        for (TodoAuthorityEnum authorityEnum : authorityEnums) {
            grantedAuthorities.add(new SimpleTodoGrantedAuthority(authorityEnum));
        }
        return grantedAuthorities;
    }
}
