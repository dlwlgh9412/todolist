package com.jjangchen.todolistbackend.web.aop.authentication.authority;

public class SimpleTodoGrantedAuthority implements TodoGrantedAuthority {
    private final TodoAuthorityEnum role;

    public SimpleTodoGrantedAuthority(TodoAuthorityEnum role) {
        this.role = role;
    }

    @Override
    public TodoAuthorityEnum getAuthority() {
        return this.role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj instanceof SimpleTodoGrantedAuthority)
            return this.role.equals(((SimpleTodoGrantedAuthority) obj).role);
        return false;
    }

    @Override
    public String toString() {
        return this.role.toString();
    }
}
