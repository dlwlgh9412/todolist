package com.jjangchen.todolistbackend.controller;

import com.jjangchen.todolistbackend.dto.TodoSaveDto;
import com.jjangchen.todolistbackend.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/todos")
public class TodoRestController {
    private final TodoService todoService;

    @PostMapping
    public Long create(@RequestBody TodoSaveDto saveDto) {
        return todoService.create(saveDto);
    }
}
