package com.jjangchen.todolistbackend.entity;

import com.jjangchen.todolistbackend.enums.TodoOauthType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TBL_TODO_ACCOUNT")
public class TodoAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;

    @Column(nullable = false)
    private Long id;

    private String nickname;

    private String profileImageUrl;

    private String email;

    @Enumerated(EnumType.STRING)
    private TodoOauthType socialType;

    @OneToMany(targetEntity = Todo.class)
    private List<Todo> todoList;

//    @Transient
//    private Set<TodoGrantedAuthority> authorities = new HashSet<>();

    public TodoAccount(Long id) {
        this.id = id;
    }
}
