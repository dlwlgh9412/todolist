package com.jjangchen.todolistbackend.dto;

import com.jjangchen.todolistbackend.entity.Todo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoSaveDto {
    private String content;
    private LocalDateTime startDate;

    public Todo toEntity() {
        return new Todo(content, startDate);
    }

    public TodoSaveDto(String content) {
        this.content = content;
    }

    public TodoSaveDto(LocalDateTime startDate) {
        this.startDate = startDate;
    }
}
