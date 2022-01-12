package com.jjangchen.todolistbackend.entity;

import com.jjangchen.todolistbackend.dto.TodoUpdateDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Todo {
    @Id
    @GeneratedValue
    private Long id;

    private String content;

    private LocalDateTime startTime;

    public Todo(String content, LocalDateTime startTime) {
        this.content = content;
        this.startTime = startTime;
    }

    public Todo update(TodoUpdateDto updateDto) {
        this.content = updateDto.getContent();
        this.startTime = updateDto.getStartTime();

        return this;
    }
}
