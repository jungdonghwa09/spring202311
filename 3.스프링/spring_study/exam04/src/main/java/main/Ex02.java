package main;

import config.AppCtx2;
import models.Message;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex02 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new
                AnnotationConfigApplicationContext(AppCtx2.class);
        //객체 생성, 의존 설정, 초기화-afterPropertiesSet
        Message m1 = ctx.getBean(Message.class);
        Message m2 = ctx.getBean(Message.class);
        System.out.println(m1==m2);
        //같은 객체를 공유, 주소가 같음
        //prototype-같지않음이 나옴
        ctx.close();//컨테이너 소멸로, 이 전에 destroy호출

    }
}
