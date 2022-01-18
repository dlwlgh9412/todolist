package com.jjangchen.todolistbackend.web.aop.todo.authentication.converter;

public enum TodoAuthenticationHeaderList {
    DEFAULT("todoauthorization");
    public String value;

    TodoAuthenticationHeaderList(String value) {
        this.value = value;
    }

    public String getKey() {
        return this.name();
    }

    public String getValue() {
        return value;
    }
}
