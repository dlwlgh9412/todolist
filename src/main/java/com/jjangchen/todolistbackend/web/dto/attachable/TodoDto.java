package com.jjangchen.todolistbackend.web.dto.attachable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jjangchen.todolistbackend.web.aop.attachment.TodoAttachmentWrapper;
import lombok.*;

import java.time.LocalDateTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TodoDto implements Attachable {
    private Long id;
    private String content;
    private LocalDateTime startTime;

    @Builder
    public TodoDto(Long id, String content, LocalDateTime startTime) {
        this.id = id;
        this.content = content;
        this.startTime = startTime;
    }

    @Setter(AccessLevel.PRIVATE)
    @JsonIgnore
    private TodoAttachmentWrapper todoAttachmentWrapper = new TodoAttachmentWrapper();
}