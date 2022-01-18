package com.jjangchen.todolistbackend.web.controller;

import com.jjangchen.todolistbackend.web.aop.attachment.Attach;
import com.jjangchen.todolistbackend.web.aop.todo.context.TodoAuthenticationContextHolder;
import com.jjangchen.todolistbackend.web.dto.attachable.TodoDto;
import com.jjangchen.todolistbackend.web.dto.TodoSaveDto;
import com.jjangchen.todolistbackend.web.service.TodoServiceTodo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/todos")
public class TodoRestController {
    private final TodoServiceTodo todoService;

    @GetMapping
    public ResponseEntity getTodoList() {
        return new ResponseEntity(todoService.findAllByUsername(), HttpStatus.OK);
    }

    @Attach
    @GetMapping("/{id}")
    public TodoDto getTodoOne(@PathVariable("id") Long id) {
        log.info(TodoAuthenticationContextHolder.getContext().getTodoAuthentication().getName());
        return todoService.findOne(id);
    }

    @PostMapping
    public Long create(@RequestBody TodoSaveDto saveDto) {
        return todoService.create(saveDto);
    }
}
