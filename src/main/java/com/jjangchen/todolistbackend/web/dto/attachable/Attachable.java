package com.jjangchen.todolistbackend.web.dto.attachable;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.jjangchen.todolistbackend.web.aop.attachment.TodoAttachmentType;
import com.jjangchen.todolistbackend.web.aop.attachment.TodoAttachmentWrapper;
import com.jjangchen.todolistbackend.web.dto.attach.Attachment;

import java.util.Map;
import java.util.stream.Collectors;

public interface Attachable {
    TodoAttachmentWrapper getTodoAttachmentWrapper();

    default void attach(Map<? extends TodoAttachmentType, ? extends Attachment> attachment) {
        getTodoAttachmentWrapper().putAll(attachment);
    }

    @JsonAnyGetter
    default Map<String, Object> getAttachment() {
        TodoAttachmentWrapper wrapper = getTodoAttachmentWrapper();

        if (wrapper.isEmpty())
            return null;

        return wrapper.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().name().toLowerCase(), Map.Entry::getValue));
    }
}
