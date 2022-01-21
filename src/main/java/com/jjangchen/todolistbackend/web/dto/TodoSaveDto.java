package com.jjangchen.todolistbackend.web.dto;

import com.jjangchen.todolistbackend.entity.TodoAccount;
import com.jjangchen.todolistbackend.entity.Todo;
import com.jjangchen.todolistbackend.web.aop.authentication.context.TodoAuthenticationContextHolder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoSaveDto implements TodoRequestDto {
    private String content;
    private LocalDateTime startDate;
    private TodoAccount todoAccount;

    public Todo toEntity() {
        return new Todo(content, startDate, todoAccount);
    }

    @Override
    public void setUser(TodoAccount account) {
        this.todoAccount = account;
    }
}
