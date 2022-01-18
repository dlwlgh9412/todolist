package com.jjangchen.todolistbackend.web.aop.attachment;


import lombok.Data;
import lombok.experimental.Delegate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Set;

@Data
@Component
@RequestScope
public class AttachmentTypeHolder {
    @Delegate
    private Set<AttachmentType> types;
}
