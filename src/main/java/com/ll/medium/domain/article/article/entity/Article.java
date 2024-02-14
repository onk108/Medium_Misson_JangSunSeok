package com.ll.medium.domain.article.article.entity;

import com.ll.medium.domain.member.member.entity.Member;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Article {
    @EqualsAndHashCode.Include
    private Long id;
    private Member author;
    private String title;
    private String body;

    public Article(Member author, String title, String body) {
        this.author = author;
        this.title = title;
        this.body = body;
    }
}
