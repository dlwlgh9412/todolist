package com.jjangchen.todolistbackend.web.client.oauth2.model;

public enum TodoOauth2RequestSeparator {
    UNDER_BAR("_");

    private String separator;

    TodoOauth2RequestSeparator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return this.separator;
    }
}
