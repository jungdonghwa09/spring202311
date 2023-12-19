package main;

import aopex.RecCalculator;
import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex02 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new
                AnnotationConfigApplicationContext(AppCtx.class);
        RecCalculator cal = ctx.getBean(RecCalculator.class);
        //rec를 가져오면 프록시로 수행해야 하는 메인을 실행했을때 오류
        //rec는 프록시를 못 가져옴, 프록시와 rec는 calculator상위 인터페이스를
        //상속받은 형제사이라서 ex02는 오류나고, ex01은 괜찮
        long result = cal.factorial(10L);
        System.out.printf("cal : %d%n", result);
        ctx.close();
    }
}
