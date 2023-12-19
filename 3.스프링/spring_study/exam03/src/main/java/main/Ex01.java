package main;

import config.AppCtx;
import config.AppCtx2;
import config.AppCtx3;
import config.AppCtx4;
import models.member.JoinService;
import models.member.ListService;
import models.member.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) {
        //아래 이 긴거는 스프링컨테이너(객체를 관리)이고 이것의 객체인 ctx의 메서드 getBean을
        //통해 AppCtx에 등록된 객체를 다룰 수 있게 함
        AnnotationConfigApplicationContext ctx = new
                AnnotationConfigApplicationContext(AppCtx4.class);
//getBean은 객체 조회, name은 메서드명이다
        JoinService joinService = ctx.getBean
                (JoinService.class);
        ListService listService = ctx.getBean
                ("listService", ListService.class);
        Member member = new Member();
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setConfirmPw("123456");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        joinService.join(member);
        listService.print();

        ctx.close();
    }
}
