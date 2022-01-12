package com.jjangchen.todolistbackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class TodoUpdateDto {
    private Long id;
    private String content;
    private LocalDateTime startTime;

    public TodoUpdateDto(String content) {
        this.content = content;
    }

    public TodoUpdateDto(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public TodoUpdateDto(String content, LocalDateTime startTime) {
        this.content = content;
        this.startTime = startTime;
    }
}
