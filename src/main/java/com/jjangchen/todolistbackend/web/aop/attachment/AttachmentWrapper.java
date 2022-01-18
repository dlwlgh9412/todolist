package com.jjangchen.todolistbackend.web.aop.attachment;

import com.jjangchen.todolistbackend.web.dto.attach.Attachment;
import lombok.experimental.Delegate;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

public class AttachmentWrapper {
    interface AttachmentMap {
        void put(AttachmentType type, Attachment attachment);
        void putAll(Map<? extends AttachmentType, ? extends Attachment> attachmentMap);
        boolean isEmpty();
        Set<Map.Entry<AttachmentType, Attachment>> entrySet();
    }

    @Delegate(types = AttachmentMap.class)
    private Map<AttachmentType, Attachment> value = new EnumMap<>(AttachmentType.class);
}
