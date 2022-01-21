package com.jjangchen.todolistbackend.entity;

import com.jjangchen.todolistbackend.web.aop.authentication.authority.TodoGrantedAuthority;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TBL_TODO_ACCOUNT")
public class TodoAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(unique = true)
    private String username;

    @OneToMany(mappedBy = "todoAccount")
    private List<Todo> todoList;

    @Transient
    private Set<TodoGrantedAuthority> authorities = new HashSet<>();

    public TodoAccount(String username) {
        this.username = username;
    }
}
