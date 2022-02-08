package com.jjangchen.todolistbackend.web.controller;

import com.jjangchen.todolistbackend.web.aop.attachment.Attach;
import com.jjangchen.todolistbackend.web.dto.TodoUpdateDto;
import com.jjangchen.todolistbackend.web.dto.attachable.TodoDto;
import com.jjangchen.todolistbackend.web.dto.TodoSaveDto;
import com.jjangchen.todolistbackend.web.service.TodoService;
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
    private final TodoService todoService;

    @GetMapping
    public ResponseEntity getTodoList() {
        return new ResponseEntity(todoService.findAllByUsername(), HttpStatus.OK);
    }

    @Attach
    @GetMapping("/{id}")
    public TodoDto getTodoOne(@PathVariable("id") Long id) {
        return todoService.findOne(id);
    }

    @PostMapping
    public Long createTodo(@RequestBody TodoSaveDto saveDto) {
        return todoService.create(saveDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable("id") Long id) {
        todoService.delete(id);
    }

    @Attach
    @PutMapping("/{id}")
    public TodoDto updateTodo(@PathVariable("id") Long id, @RequestBody TodoUpdateDto updateDto) {
        return todoService.update(id, updateDto);
    }
}
