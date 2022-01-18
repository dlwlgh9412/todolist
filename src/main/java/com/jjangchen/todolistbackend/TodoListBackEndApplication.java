package com.jjangchen.todolistbackend;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RequiredArgsConstructor
@SpringBootApplication
public class TodoListBackEndApplication {
    public static void main(String[] args) {
        SpringApplication.run(TodoListBackEndApplication.class, args);
    }

}
