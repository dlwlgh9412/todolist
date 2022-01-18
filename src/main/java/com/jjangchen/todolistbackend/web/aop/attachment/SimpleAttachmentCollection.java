package com.jjangchen.todolistbackend.web.aop.attachment;

import com.jjangchen.todolistbackend.web.dto.attach.Attachment;
import lombok.experimental.Delegate;

import java.util.Collection;

public class SimpleAttachmentCollection<T extends Attachment> implements AttachmentCollection<T> {
    @Delegate
    private final Collection<T> value;

    public SimpleAttachmentCollection(Collection<T> value) {
        this.value = value;
    }
}
