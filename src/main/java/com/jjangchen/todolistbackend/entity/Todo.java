package com.jjangchen.todolistbackend.entity;

import com.jjangchen.todolistbackend.web.filter.converter.authentication.TodoAuthenticationResolverException;
import com.jjangchen.todolistbackend.web.dto.TodoUpdateDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TBL_TODO")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private LocalDateTime startTime;

    @OneToMany(targetEntity = TodoAttach.class, mappedBy = "todo")
    private List<TodoAttach> todoAttachList = new ArrayList<>();

    @ManyToOne(targetEntity = TodoAccount.class)
    @JoinColumn(name = "WRITER")
    private TodoAccount todoAccount;

    @Builder
    public Todo(String content, LocalDateTime startTime, TodoAccount todoAccount) {
        this.content = content;
        this.startTime = startTime;
        this.todoAccount = todoAccount;
    }

    public Todo update(TodoUpdateDto updateDto) {
        if(todoAccount != updateDto.getAccount())
            throw new TodoAuthenticationResolverException("해당 작성자가 아닙니다!!");
        this.content = updateDto.getContent();
        this.startTime = updateDto.getStartTime();

        return this;
    }
}
