package org.choongang.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.aspectj.lang.annotation.Before;
import org.choongang.entities.BoardData;
import org.choongang.entities.HashTag;
import org.choongang.repositories.BoardDataRepository;
import org.choongang.repositories.HashTagRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex08Test {
    @Autowired
    private BoardDataRepository boardDataRepository;
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private HashTagRepository hashTagRepository;

    @BeforeEach
    void init(){
        List<HashTag> tags = new ArrayList<>();

        for(int i=1; i<=5; i++) {
        HashTag tag = new HashTag();
        tag.setTag("태그"+i);
        tags.add(tag);
        }
        hashTagRepository.saveAllAndFlush(tags);

        List<BoardData> items = new ArrayList<>();
        for(int i=1; i<=5; i++){
            BoardData item = new BoardData();
            item.setSubject("제목"+i);
            item.setContent("내용"+i);
            item.setTags(tags);
            items.add(item);
        }
        boardDataRepository.saveAllAndFlush(items);
        em.clear();
    }
    @Test
    void test1(){
        BoardData item = boardDataRepository.findById(1L).orElse(null);
    List<HashTag> tags = item.getTags();
    System.out.println(tags);
    }
    @Test
    void test2(){
        HashTag tag = hashTagRepository.findById("태그1").orElse(null);
    List<BoardData> items = tag.getItems();
    items.forEach(System.out::println);//실행하려면 어느한쪽을 배제
    }
}
