package com.jjangchen.todolistbackend.service;

import com.jjangchen.todolistbackend.dto.TodoResponseDto;
import com.jjangchen.todolistbackend.dto.TodoSaveDto;
import com.jjangchen.todolistbackend.dto.TodoUpdateDto;
import com.jjangchen.todolistbackend.entity.Todo;
import com.jjangchen.todolistbackend.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public List<TodoResponseDto> findAll() {
        return todoRepository.findAll().stream().map(todo -> new TodoResponseDto(todo.getContent(), todo.getStartTime())).collect(Collectors.toList());
    }
    public Long create(TodoSaveDto saveDto) {
        return todoRepository.save(saveDto.toEntity()).getId();
    }

    public Todo update(TodoUpdateDto updateDto) {
        return todoRepository.findById(updateDto.getId()).orElseThrow(EntityNotFoundException::new).update(updateDto);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
