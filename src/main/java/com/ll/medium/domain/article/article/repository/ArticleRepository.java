package com.ll.medium.domain.article.article.repository;

import com.ll.medium.domain.article.article.entity.Article;
import com.ll.medium.domain.member.member.entity.Member;
import com.ll.medium.domain.member.member.repository.MemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ArticleRepository {
    private final List<Article> articles = new ArrayList<>();

    public Article save(Article article) {
        if (article.getId() == null) {
            article.setId(articles.size() + 1L);
        }

        articles.add(article);

        return article;
    }

    public List<Article> findAll() {
        return articles;
    }

    public Optional<Article> findById(long id) {
        return articles.stream()
                .filter(article -> article.getId() == id)
                .findFirst();
    }

    public void delete(Article article) {
        articles.remove(article);
    }
}
