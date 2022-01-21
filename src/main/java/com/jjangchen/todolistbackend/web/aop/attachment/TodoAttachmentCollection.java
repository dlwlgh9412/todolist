package com.jjangchen.todolistbackend.web.aop.attachment;

import com.jjangchen.todolistbackend.web.dto.attach.Attachment;

import java.util.Collection;

public interface TodoAttachmentCollection<T extends Attachment> extends Attachment, Collection<T> {
}
