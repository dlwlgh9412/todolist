package com.jjangchen.todolistbackend.web.dto.attach;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AttachDto implements Attachment {
    private String content;
}
