package org.choongang.tests;

import lombok.extern.slf4j.Slf4j;
import org.choongang.entities.Member;
import org.choongang.repositories.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.List;
@Slf4j
@SpringBootTest
public class JdbcEx01 {
    @Autowired
    private JdbcTemplate jdbcTemplate;//복잡한 쿼리--빈으로 자동추가
    @Autowired
    private MemberRepository repository;
    @Test
    void test1(){
        List<Member> members = (List<Member>) repository.findAll();
        members.forEach(System.out::println);
    }
    @Test
    void test2(){
//        Member member = Member.builder()
//                .userNo(19L)
//                .userId("user03")
//                .userPw("12345678")
//                .userNm("사용자03")
//                .email("user03@test.org")
//                .build(); //스프링부트에서는 기본키때문에 뭔가 오류난듯
        Member member = repository.findById(18L).orElse(null);
        member.setUserNm("(수정)사용자02");
        member.setModDt(LocalDateTime.now());
        //findById로 이미있는거 조회후,수정
        repository.save(member);
    }
    @Test
    void test3(){
        Member member = repository.findByUserId("user01");
    log.info(member.toString());
    //userId로 조회하는 로거를 출력
    }
    @Test
    void test4(){
        List<Member> members = repository
                .findByUserNmContainingOrUserIdContainingOrderByRegDtDesc
                        ("용","Id");
        members.forEach(System.out::println);
    }
    @Test
    void test5(){
        List<Member> members = repository.getMembers
                ("사용자","user");
        members.forEach(System.out::println);
    }
    @Test
    void test6(){
        Pageable pageable = PageRequest.of(0,10,
                Sort.by(Sort.Order.desc("regDt"),
                        Sort.Order.asc("userId")));
        Page<Member> data = repository.findByUserNmContaining("사용자",pageable);
        List<Member> members = data.getContent();
        long total = data.getTotalElements();
        int totalPages = data.getTotalPages();
    }

}
