package com.jjangchen.todolistbackend.web.service;

import com.jjangchen.todolistbackend.web.dto.attach.Attachment;
import com.jjangchen.todolistbackend.web.aop.attachment.TodoAttachmentType;
import com.jjangchen.todolistbackend.web.aop.attachment.TodoSimpleTodoAttachmentCollection;
import com.jjangchen.todolistbackend.web.dto.attach.AttachDto;
import com.jjangchen.todolistbackend.web.dto.attachable.TodoDto;
import com.jjangchen.todolistbackend.web.dto.TodoSaveDto;
import com.jjangchen.todolistbackend.web.dto.TodoUpdateDto;
import com.jjangchen.todolistbackend.entity.Todo;
import com.jjangchen.todolistbackend.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class TodoService implements TodoAttachService<TodoDto> {
    private static final TodoAttachmentType TODO_ATTACHMENT_TYPE = TodoAttachmentType.TODO_ATTACH;
    private static final Class<TodoDto> supportType = TodoDto.class;
    private final TodoRepository todoRepository;
    private final TodoAccountService accountService;

    public List<TodoDto> findAllByUsername() {
        return todoRepository.findAllByTodoAccount(accountService.loadAccountByContext()).stream().map(todo ->
                        createTodoDto(todo))
                .collect(Collectors.toList());
    }

    public TodoDto findOne(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return createTodoDto(todo);
    }

    @Transactional
    public Long create(TodoSaveDto saveDto) {
        return todoRepository.save(saveDto.toEntity()).getId();
    }

    @Transactional
    public TodoDto update(Long id, TodoUpdateDto updateDto) {
        Todo todo = todoRepository.findById(id).orElseThrow().update(updateDto);
        return createTodoDto(todo);
    }

    @Transactional
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    private TodoDto createTodoDto(Todo todo) {
        return TodoDto.builder()
                .id(todo.getId())
                .content(todo.getContent())
                .startTime(todo.getStartTime())
                .build();
    }

    @Override
    public TodoAttachmentType getSupportAttachmentType() {
        return TODO_ATTACHMENT_TYPE;
    }

    @Override
    public Class<TodoDto> getSupportType() {
        return supportType;
    }

    @Override
    public Attachment getAttachment(Object attachment) {
        TodoDto todoDto = supportType.cast(attachment);
        return new TodoSimpleTodoAttachmentCollection<>(todoRepository.findById(todoDto.getId())
                .orElseThrow().getTodoAttachList().stream().map(addon -> new AttachDto(addon.getContent())).collect(Collectors.toList()));
    }
}
