package com.jjangchen.todolistbackend.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TBL_TODO_ATTACH")
public class TodoAttach {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "TODO_ID")
    private Todo todo;

    public TodoAttach(String content, Todo todo) {
        this.content = content;
        this.todo = todo;
    }
}
