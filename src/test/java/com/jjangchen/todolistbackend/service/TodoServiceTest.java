package com.jjangchen.todolistbackend.service;


import com.jjangchen.todolistbackend.dto.TodoResponseDto;
import com.jjangchen.todolistbackend.dto.TodoSaveDto;
import com.jjangchen.todolistbackend.dto.TodoUpdateDto;
import com.jjangchen.todolistbackend.entity.Todo;
import com.jjangchen.todolistbackend.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.sql.Ref;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {
    @InjectMocks
    private TodoService todoService;

    @Mock
    private TodoRepository todoRepository;

    @BeforeEach
    void setTodoRepository() {

    }

    @Test
    public void Todo_생성() {
        TodoSaveDto todoSaveDto = new TodoSaveDto("해야할 것", LocalDateTime.now());
        Todo todo = todoSaveDto.toEntity();

        //ReflectionTestUtils.setField(todo, "id", 1L);

        //given
        given(todoRepository.save(any(Todo.class))).willReturn(todo);
        //given(todoRepository.findById(any(Long.class))).willReturn(Optional.of(any(Todo.class)));

        // when
        Long resultId = todoService.create(todoSaveDto);

        // then
        assertEquals(todo.getId(), resultId);
        //assertEquals(todo.getId(), findTodo.getId());
    }

    @Test
    public void Todo_수정() {
        final TodoUpdateDto updateDto = new TodoUpdateDto("수정");
        final Todo todo = new Todo("해야할 것", LocalDateTime.now());

        given(todoRepository.findById(any())).willReturn(Optional.of(todo));

        // when
        Todo updateTodo = todoService.update(updateDto);

        // assert
        assertEquals(todo.getContent(), updateTodo.getContent());
        assertEquals(todo.getStartTime(), updateTodo.getStartTime());
    }

    @Test
    public void Todo_삭제() {
        final Long postId = 1L;

        //doNothing().when(todoRepository).deleteById(any(Long.class));

        todoService.delete(postId);
        verify(todoRepository, times(1)).deleteById(1L);
    }

    @Test
    public void Todo_조회() {
        final Todo todo1 = new Todo("해야할 일", LocalDateTime.now());
        final Todo todo2 = new Todo("해야할 일2", LocalDateTime.now());
        final Todo todo3 = new Todo("헤야할 일3", LocalDateTime.now());

        List<Todo> todoList = new ArrayList<>();
        todoList.add(todo1);
        todoList.add(todo2);
        todoList.add(todo3);

        // given
        given(todoRepository.findAll()).willReturn(todoList);

        List<TodoResponseDto> todoResponseDtoList = todoService.findAll();

        for(var i = 0; i < 3; i++) {
            assertEquals(todoList.get(i).getContent(), todoResponseDtoList.get(i).getContent());
            assertEquals(todoList.get(i).getStartTime(), todoResponseDtoList.get(i).getStartTime());
        }

    }
}
