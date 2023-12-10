package com.ll.medium.global.initData;

import com.ll.medium.domain.article.article.service.ArticleService;
import com.ll.medium.domain.member.member.entity.Member;
import com.ll.medium.domain.member.member.service.MemberService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotProd {
    @Bean
    public ApplicationRunner initNotProd(
            MemberService memberService,
            ArticleService articleService
    ) {
        return args -> {
            Member memberAdmin = memberService.join("admin", "1234");
            Member memberUser1 = memberService.join("user1", "1234");
            Member memberUser2 = memberService.join("user2", "1234");

            articleService.write(memberAdmin, "제목1", "내용1");
            articleService.write(memberAdmin, "제목2", "내용2");
            articleService.write(memberAdmin, "제목3", "내용3");
        };
    }
}