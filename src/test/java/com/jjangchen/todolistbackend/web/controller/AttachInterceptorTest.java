package com.jjangchen.todolistbackend.web.controller;

import com.jjangchen.todolistbackend.web.aop.attachment.Attach;
import com.jjangchen.todolistbackend.web.interceptor.AttachInterceptor;
import com.jjangchen.todolistbackend.web.aop.attachment.TodoAttachmentType;
import com.jjangchen.todolistbackend.web.aop.attachment.TodoAttachmentTypeHolder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.method.HandlerMethod;

import static org.mockito.BDDMockito.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class AttachInterceptorTest {
    @InjectMocks
    private AttachInterceptor attachInterceptor;

    @Spy
    private TodoAttachmentTypeHolder todoAttachmentTypeHolder;

    @Mock
    private HandlerMethod handlerMethod;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void preHandler() {
        given(handlerMethod.hasMethodAnnotation(Attach.class)).willReturn(true);
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setParameter(AttachInterceptor.TARGET_PARAMETER_NAME, TodoAttachmentType.COMMENTS.name().toLowerCase());
        MockHttpServletResponse response = new MockHttpServletResponse();

        attachInterceptor.preHandle(request, response, handlerMethod);

        assertThat(todoAttachmentTypeHolder.getTypes(), hasItem(TodoAttachmentType.COMMENTS));
    }
}
