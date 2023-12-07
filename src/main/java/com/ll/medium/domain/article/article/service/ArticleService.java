package com.ll.medium.domain.article.article.service;

import com.ll.medium.domain.article.article.entity.Article;
import com.ll.medium.domain.article.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;

    public Article write(String title, String body) {
        Article article = new Article(title, body);

        articleRepository.save(article);

        return article;
    }

    public Article findLastArticle() {
        return articleRepository.findLastArticle();
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Optional<Article> findById(long id) {
        return articleRepository.findById(id);
    }
}
