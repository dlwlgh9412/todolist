package com.jjangchen.todolistbackend.web.service;

import com.jjangchen.todolistbackend.entity.TodoAccount;
import com.jjangchen.todolistbackend.web.aop.todo.context.TodoAuthenticationContextHolder;
import com.jjangchen.todolistbackend.web.dto.attach.Attachment;
import com.jjangchen.todolistbackend.web.aop.attachment.AttachmentType;
import com.jjangchen.todolistbackend.web.aop.attachment.SimpleAttachmentCollection;
import com.jjangchen.todolistbackend.web.dto.attach.TodoAttachDto;
import com.jjangchen.todolistbackend.web.dto.attachable.TodoDto;
import com.jjangchen.todolistbackend.web.dto.TodoSaveDto;
import com.jjangchen.todolistbackend.web.dto.TodoUpdateDto;
import com.jjangchen.todolistbackend.entity.Todo;
import com.jjangchen.todolistbackend.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class TodoService implements AttachService<TodoDto> {
    private static final AttachmentType attachmentType = AttachmentType.TODO_ATTACH;
    private static final Class<TodoDto> supportType = TodoDto.class;
    private final TodoRepository todoRepository;
    private final TodoAccountService accountService;

    public List<TodoDto> findAllByUsername() {
        return todoRepository.findAllByTodoAccount(loadUser()).stream().map(todo ->
                        TodoDto.builder()
                                .id(todo.getId())
                                .content(todo.getContent())
                                .startTime(todo.getStartTime())
                                .build())
                .collect(Collectors.toList());
    }

    public TodoDto findOne(Long id) {
        Todo todo = todoRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return TodoDto.builder()
                .id(todo.getId())
                .content(todo.getContent())
                .startTime(todo.getStartTime())
                .build();
    }

    public Long create(TodoSaveDto saveDto) {
        return todoRepository.save(saveDto.toEntity()).getId();
    }

    public Todo update(TodoUpdateDto updateDto) {
        return todoRepository.findById(updateDto.getId()).orElseThrow().update(updateDto);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public AttachmentType getSupportAttachmentType() {
        return attachmentType;
    }

    @Override
    public Class<TodoDto> getSupportType() {
        return supportType;
    }

    @Override
    public Attachment getAttachment(Object attachment) {
        TodoDto todoDto = supportType.cast(attachment);
        return new SimpleAttachmentCollection<>(todoRepository.findById(todoDto.getId())
                .orElseThrow().getTodoAttachList().stream().map(addon -> new TodoAttachDto(addon.getContent())).collect(Collectors.toList()));
    }

    private TodoAccount loadUser() {
        return accountService.loadAccountByUsername(TodoAuthenticationContextHolder.getContext().getTodoAuthentication().getName());
    }
}
