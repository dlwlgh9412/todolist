package com.jjangchen.todolistbackend.web.dto.attachable;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.jjangchen.todolistbackend.web.aop.attachment.AttachmentType;
import com.jjangchen.todolistbackend.web.aop.attachment.AttachmentWrapper;
import com.jjangchen.todolistbackend.web.dto.attach.Attachment;

import java.util.Map;
import java.util.stream.Collectors;

public interface Attachable {
    AttachmentWrapper getAttachmentWrapper();

    default void attach(Map<? extends AttachmentType, ? extends Attachment> attachment) {
        getAttachmentWrapper().putAll(attachment);
    }

    @JsonAnyGetter
    default Map<String, Object> getAttachment() {
        AttachmentWrapper wrapper = getAttachmentWrapper();

        if (wrapper.isEmpty())
            return null;

        return wrapper.entrySet()
                .stream()
                .collect(Collectors.toMap(e -> e.getKey().name().toLowerCase(), Map.Entry::getValue));
    }
}
