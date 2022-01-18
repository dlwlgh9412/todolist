package com.jjangchen.todolistbackend.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jjangchen.todolistbackend.web.dto.TodoSaveDto;
import com.jjangchen.todolistbackend.web.service.TodoServiceTodo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.ManualRestDocumentation;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.BDDMockito.*;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
public class TodoRestControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TodoServiceTodo todoService;

    private ManualRestDocumentation restDocumentation = new ManualRestDocumentation();

    /*
    @BeforeEach
    public void setUp(Method method) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build();
        this.restDocumentation.beforeTest(getClass(), method.getName());
    }

     */

    @AfterEach
    public void tearDown() {
        this.restDocumentation.afterTest();
    }

    @Test
    void TODO_생성요청() throws Exception {
        TodoSaveDto todoSaveDto = new TodoSaveDto("해야할 것");
        when(todoService.create(todoSaveDto)).thenReturn(anyLong());
        //given(todoService.create(any(TodoSaveDto.class))).willReturn(any(Long.class));
        Map<String, Object> request = new HashMap<>();
        request.put("content", "해야할 것");
        Map<String, Object> response = new HashMap<>();
        response.put("id", "게시글 번호");
        MvcResult mvcResult = mockMvc.perform(post("/todos")
                        .content(objectMapper.writeValueAsString(todoSaveDto))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andDo(document("post-create", requestBody(request)))
                        //requestFields(fieldWithPath("content").description("TODO 할일")),
                        //requestFields(fieldWithPath("startDate").description("날짜"))))
                .andReturn();

        String responseBody = mvcResult.getResponse().getContentAsString();

        assertEquals("0", responseBody);

    }
}
