package com.ll.medium.domain.article.article.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ArticleControllerTest {
    @Autowired
    private MockMvc mvc;

    // GET /article/list
    @Test
    @DisplayName("게시글 목록 페이지를 보여준다")
    void t1() throws Exception {
        // WHEN
        ResultActions resultActions = mvc
                .perform(get("/article/list"))
                .andDo(print());
    }
    // GET /article/detail/{id}
    // GET /article/write
    // POST /article/write
    // GET /article/modify/{id}
    // PUT /article/modify/{id}
    // DELETE /article/delete/{id}
}
