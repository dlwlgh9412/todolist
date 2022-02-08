package com.jjangchen.todolistbackend.web.dto;

public enum TodoOauthRequestSeparator {
    UNDER_BAR("_");

    private String separator;

    TodoOauthRequestSeparator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return this.separator;
    }
}
