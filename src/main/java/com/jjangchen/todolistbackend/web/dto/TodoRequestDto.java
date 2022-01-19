package com.jjangchen.todolistbackend.web.dto;

import com.jjangchen.todolistbackend.entity.TodoAccount;

public interface TodoRequestDto {
    void setUser(TodoAccount account);
}
