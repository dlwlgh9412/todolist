package com.jjangchen.todolistbackend.web.aop.todo.authentication;

import com.jjangchen.todolistbackend.entity.TodoAccount;
import com.jjangchen.todolistbackend.web.aop.todo.authority.TodoAuthorityUtils;
import com.jjangchen.todolistbackend.web.aop.todo.authority.TodoGrantedAuthority;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;

public abstract class TodoAbstractAuthentication implements TodoAuthentication {
    private final Collection<TodoGrantedAuthority> authorities;
    private boolean isAuthenticated = false;

    public TodoAbstractAuthentication(Collection<? extends TodoGrantedAuthority> authorities) {
        if(authorities == null)
            authorities = TodoAuthorityUtils.NO_AUTHORITIES;
        else
            for(TodoGrantedAuthority authority : authorities) {
                Assert.notNull(authority, "권한 목록은 null 값을 담을 수 없습니다.");
            }
            this.authorities = new ArrayList<>(authorities);
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        this.isAuthenticated = authenticated;
    }

    @Override
    public boolean isAuthenticated() {
        return this.isAuthenticated;
    }


    @Override
    public String getName() {
        if (this.getPrincipal() instanceof TodoAccount)
            return ((TodoAccount) this.getPrincipal()).getUsername();
        if (this.getPrincipal() instanceof TodoPrincipal) {
            return ((TodoPrincipal) this.getPrincipal()).getName();
        }

        if (this.getPrincipal() == null)
            return "";
        else
            return this.getPrincipal().toString();
    }

}
