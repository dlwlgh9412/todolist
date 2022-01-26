package com.jjangchen.todolistbackend.web.client.oauth2.model;

public enum TodoSocialRequestSeparator {
    UNDER_BAR("_");

    private String separator;

    TodoSocialRequestSeparator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return this.separator;
    }
}
