package com.jjangchen.todolistbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TodoResponseDto {
    private String content;
    private LocalDateTime startTime;
}
