package com.ll.medium.global.app;

import com.ll.medium.domain.article.article.entity.Article;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Configuration
public class AppConfig {
    @Bean
    List<Article> articles2() {
        return new LinkedList<>();
    }

    @Bean
    List<Article> articles() {
        return new ArrayList<>();
    }
}
