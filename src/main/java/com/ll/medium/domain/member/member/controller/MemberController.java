package com.ll.medium.domain.member.member.controller;

import com.ll.medium.domain.member.member.entity.Member;
import com.ll.medium.domain.member.member.service.MemberService;
import com.ll.medium.global.rq.Rq;
import com.ll.medium.global.rsData.RsData;
import jakarta.servlet.http.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpServletResponse;


@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final Rq rq;

    @PreAuthorize("isAnonymous()")
    @GetMapping("/member/login")
    String showLogin() {
        return "member/member/login";
    }

    @Data
    public static class LoginForm {
        @NotBlank
        private String username;
        @NotBlank
        private String password;
    }


    @PostMapping("/member/login")
    String login(@Valid LoginForm loginForm) {
        Member member = memberService.findByUsername(loginForm.username).get();

        if (!member.getPassword().equals(loginForm.password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        rq.setSessionAttr("loginedMemberId", member.getId());
        rq.setSessionAttr("authorities", member.getAuthorities());

        return rq.redirect("/article/list", "로그인이 완료되었습니다.");
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping("/member/join")
    String showJoin() {
        return "member/member/join";
    }

    @Data
    public static class JoinForm {
        @NotBlank
        private String username;
        @NotBlank
        private String password;
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/member/join")
    String join(@Valid JoinForm joinForm) {
        RsData<Member> joinRs = memberService.join(joinForm.username, joinForm.password);

        return rq.redirect("/member/login", joinRs.getMsg());
    }
}
