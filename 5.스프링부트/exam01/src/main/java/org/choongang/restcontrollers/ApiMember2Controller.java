package org.choongang.restcontrollers;

import org.choongang.entities.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/member2")
public class ApiMember2Controller {
    @GetMapping("/info")
    public Member info(){
        Member member = Member.builder()
                .userNo(1L)
                .userId("user01")
                .userPw("12345678")
                .email("user01@test.org")
                .userNm("사용자01")
                .regDt(LocalDateTime.now())
                .build();
    return member;
    }

}
