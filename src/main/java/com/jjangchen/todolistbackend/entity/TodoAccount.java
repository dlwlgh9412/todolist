package com.jjangchen.todolistbackend.entity;

import com.jjangchen.todolistbackend.enums.TodoSocialType;
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
    private String id;

    private String nickname;

    private String profileImageUrl;

    private String email;

    @Enumerated(EnumType.STRING)
    private TodoSocialType socialType;

    @OneToMany(mappedBy = "todoAccount")
    private List<Todo> todoList;

//    @Transient
//    private Set<TodoGrantedAuthority> authorities = new HashSet<>();

    public TodoAccount(String id) {
        this.id = id;
    }
}
