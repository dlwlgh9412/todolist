package com.jjangchen.todolistbackend.web.service;

import com.jjangchen.todolistbackend.web.dto.attachable.Attachable;
import com.jjangchen.todolistbackend.web.dto.attach.Attachment;
import com.jjangchen.todolistbackend.web.aop.attachment.AttachmentType;

public interface AttachService<T extends Attachable> {
    AttachmentType getSupportAttachmentType();
    Class<T> getSupportType();
    Attachment getAttachment(Object attachment);
}
