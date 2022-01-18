package com.jjangchen.todolistbackend.web.aop.aspect;

import com.jjangchen.todolistbackend.web.dto.attachable.Attachable;
import com.jjangchen.todolistbackend.web.dto.attach.Attachment;
import com.jjangchen.todolistbackend.web.aop.attachment.TodoAttachmentType;
import com.jjangchen.todolistbackend.web.aop.attachment.TodoAttachmentTypeHolder;
import com.jjangchen.todolistbackend.web.service.TodoAttachService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
@Aspect
public class TodoAttachmentAspect {
    private final TodoAttachmentTypeHolder todoAttachmentTypeHolder;
    private final Map<TodoAttachmentType, List<TodoAttachService>> typeToServiceMap;

    public TodoAttachmentAspect(TodoAttachmentTypeHolder todoAttachmentTypeHolder, List<TodoAttachService<? extends Attachable>> todoAttachServices) {
        this.todoAttachmentTypeHolder = todoAttachmentTypeHolder;
        this.typeToServiceMap = todoAttachServices.stream().collect(Collectors.groupingBy(TodoAttachService::getSupportAttachmentType));
    }

    @Pointcut("@annotation(com.jjangchen.todolistbackend.web.aop.attachment.Attach)")
    private void pointcut() {}

    @AfterReturning(pointcut = "pointcut()", returning = "returnValue")
    public Object afterReturning(Object returnValue) {

        if(todoAttachmentTypeHolder.isEmpty() && !(returnValue instanceof Attachable)) {
            return returnValue;
        }
        executeAttach((Attachable) returnValue);
        return returnValue;
    }

    private void executeAttach(Attachable attachable) {
        Set<TodoAttachmentType> types = todoAttachmentTypeHolder.getTypes();
        Class attachableClass = attachable.getClass();

        Map<TodoAttachmentType, Attachment> attachmentMap = types.stream().flatMap(type -> typeToServiceMap.get(type).stream())
                .filter(service -> service.getSupportType().isAssignableFrom(attachableClass))
                .collect(Collectors.toMap(TodoAttachService::getSupportAttachmentType, service -> service.getAttachment(attachable)));

        attachable.attach(attachmentMap);
    }
}
