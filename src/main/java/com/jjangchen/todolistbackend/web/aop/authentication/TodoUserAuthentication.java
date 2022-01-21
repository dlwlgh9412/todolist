package com.jjangchen.todolistbackend.web.aop.authentication;

import com.jjangchen.todolistbackend.web.aop.authentication.authority.TodoGrantedAuthority;
import org.springframework.util.Assert;

import java.util.Collection;

public class TodoUserAuthentication extends TodoAbstractAuthentication {
    private Object principal;

    public TodoUserAuthentication(Object principal) {
        super(null);
        this.principal = principal;
        setAuthenticated(false);
    }

    public TodoUserAuthentication(Collection<? extends TodoGrantedAuthority> authorities, Object principal) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true);
    }

    @Override
    public Object getPrincipal() {
        return this.principal;
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        Assert.isTrue(!authenticated, "");
        super.setAuthenticated(false);
    }
}
