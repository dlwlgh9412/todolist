package com.jjangchen.todolistbackend.web.filter.converter.authentication;

public enum TodoAuthenticationHeaderType {
    DEFAULT("authorization");

    public String value;

    TodoAuthenticationHeaderType(String value) {
        this.value = value;
    }

    public String getKey() {
        return this.name();
    }

    public String getValue() {
        return value;
    }
}
