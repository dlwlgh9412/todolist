package com.jjangchen.todolistbackend.web.service;

import com.jjangchen.todolistbackend.web.dto.attachable.Attachable;
import com.jjangchen.todolistbackend.web.dto.attach.Attachment;
import com.jjangchen.todolistbackend.web.aop.attachment.TodoAttachmentType;

public interface TodoAttachService<T extends Attachable> {
    TodoAttachmentType getSupportAttachmentType();
    Class<T> getSupportType();
    Attachment getAttachment(Object attachment);
}
