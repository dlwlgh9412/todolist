package com.jjangchen.todolistbackend.web.interceptor;

import com.jjangchen.todolistbackend.web.aop.attachment.Attach;
import com.jjangchen.todolistbackend.web.aop.attachment.TodoAttachmentType;
import com.jjangchen.todolistbackend.web.aop.attachment.TodoAttachmentTypeHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class AttachInterceptor implements HandlerInterceptor {
    public static final String TARGET_PARAMETER_NAME = "attachment";
    private final Map<HandlerMethod, Boolean> attachableMap = new ConcurrentHashMap<>();
    private final TodoAttachmentTypeHolder attachTypeHolder;

    public AttachInterceptor(TodoAttachmentTypeHolder attachTypeHolder) {
        this.attachTypeHolder = attachTypeHolder;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if(!(handler instanceof HandlerMethod))
            return true;

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        boolean isAttachable = attachableMap.computeIfAbsent(handlerMethod, key -> key.hasMethodAnnotation(Attach.class));
        if(!isAttachable)
            return true;

        Set<TodoAttachmentType> types = resolveAttachmentType(request);
        attachTypeHolder.setTypes(types);

        return true;
    }

    private Set<TodoAttachmentType> resolveAttachmentType(HttpServletRequest request) {
        String attachments = request.getParameter(TARGET_PARAMETER_NAME);

        if(!StringUtils.hasText(attachments))
            return Collections.emptySet();

        return Stream.of(attachments.split(","))
                .map(String::toUpperCase)
                .map(TodoAttachmentType::valueOf)
                .collect(Collectors.toSet());
    }
}
