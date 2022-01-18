package com.jjangchen.todolistbackend.web.aop.aspect;

import com.jjangchen.todolistbackend.web.dto.attachable.Attachable;
import com.jjangchen.todolistbackend.web.dto.attach.Attachment;
import com.jjangchen.todolistbackend.web.aop.attachment.AttachmentType;
import com.jjangchen.todolistbackend.web.aop.attachment.AttachmentTypeHolder;
import com.jjangchen.todolistbackend.web.service.AttachService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
@Aspect
public class AttachmentAspect {
    private final AttachmentTypeHolder attachmentTypeHolder;
    private final Map<AttachmentType, List<AttachService>> typeToServiceMap;

    public AttachmentAspect(AttachmentTypeHolder attachmentTypeHolder, List<AttachService<? extends Attachable>> attachServices) {
        this.attachmentTypeHolder = attachmentTypeHolder;
        this.typeToServiceMap = attachServices.stream().collect(Collectors.groupingBy(AttachService::getSupportAttachmentType));
    }

    @Pointcut("@annotation(com.jjangchen.todolistbackend.web.aop.attachment.Attach)")
    private void pointcut() {}

    @AfterReturning(pointcut = "pointcut()", returning = "returnValue")
    public Object afterReturning(Object returnValue) {

        if(attachmentTypeHolder.isEmpty() && !(returnValue instanceof Attachable)) {
            return returnValue;
        }
        executeAttach((Attachable) returnValue);
        return returnValue;
    }

    private void executeAttach(Attachable attachable) {
        Set<AttachmentType> types = attachmentTypeHolder.getTypes();
        Class attachableClass = attachable.getClass();

        Map<AttachmentType, Attachment> attachmentMap = types.stream().flatMap(type -> typeToServiceMap.get(type).stream())
                .filter(service -> service.getSupportType().isAssignableFrom(attachableClass))
                .collect(Collectors.toMap(AttachService::getSupportAttachmentType, service -> service.getAttachment(attachable)));

        attachable.attach(attachmentMap);
    }
}
