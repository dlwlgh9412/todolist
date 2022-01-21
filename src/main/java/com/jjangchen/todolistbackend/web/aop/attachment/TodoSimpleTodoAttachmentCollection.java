package com.jjangchen.todolistbackend.web.aop.attachment;

import com.jjangchen.todolistbackend.web.dto.attach.Attachment;
import lombok.experimental.Delegate;

import java.util.Collection;

public class TodoSimpleTodoAttachmentCollection<T extends Attachment> implements TodoAttachmentCollection<T> {
    @Delegate
    private final Collection<T> value;

    public TodoSimpleTodoAttachmentCollection(Collection<T> value) {
        this.value = value;
    }
}
