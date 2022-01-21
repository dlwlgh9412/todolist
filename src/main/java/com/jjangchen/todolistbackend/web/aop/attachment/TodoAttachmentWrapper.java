package com.jjangchen.todolistbackend.web.aop.attachment;

import com.jjangchen.todolistbackend.web.dto.attach.Attachment;
import lombok.experimental.Delegate;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class TodoAttachmentWrapper {
    interface AttachmentMap {
        void put(TodoAttachmentType type, Attachment attachment);
        void putAll(Map<? extends TodoAttachmentType, ? extends Attachment> attachmentMap);
        boolean isEmpty();
        Set<Map.Entry<TodoAttachmentType, Attachment>> entrySet();
    }

    @Delegate(types = AttachmentMap.class)
    private Map<TodoAttachmentType, Attachment> value = new EnumMap<>(TodoAttachmentType.class);
}
