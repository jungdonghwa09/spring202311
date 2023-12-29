package org.choongang.jpaex;

import org.choongang.entities.BoardData;
import org.choongang.repositories.BoardDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
//@TestPropertySource(properties="spring.profiles.active=test")
public class Ex04Test {
    @Autowired//이미 컨테이너안에 있는것
    private BoardDataRepository repository;

    @BeforeEach
    void init(){
        List<BoardData> items = new ArrayList<>();
        for(int i=1; i<=10;i++){
            BoardData item = new BoardData();
            item.setSubject("제목"+i);
            item.setContent("내용"+i);
            items.add(item);
        }
        repository.saveAllAndFlush(items);

    }
    @Test
    void test1(){
        //List<BoardData> items = repository.findBySubjectContaining("목");
        List<BoardData> items = repository.
                findBySubjectContainingOrderBySeqDesc("목");
        items.forEach(System.out::println);

    }
    @Test
    void test2(){
        Pageable pageable = PageRequest.of(0,3,
                Sort.by(Sort.Order.desc("createdAt")));
        //""에는 엔티티의 속성명으로 입력 이건 db의 created_At로 쿼리작성됨
        Page<BoardData> data = repository.findBySubjectContaining("목",
                pageable);
        List<BoardData> items =data.getContent();
    items.forEach(System.out::println);
    }

}
