package main;

import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import aopex.*;
public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new
                AnnotationConfigApplicationContext(AppCtx.class);
        //아래에 적은 건 getBean으로부터 가져올 때 타입이 항상 같아야 되는건지
        //아래와 같이 불러오면 프록시객체가 불러와진다
        Calculator cal = ctx.getBean(Calculator.class);
        long result = cal.factorial(10L);
        System.out.printf("cal : %d%n", result);

        long result2 = cal.factorial(10L);
        long result3 = cal.factorial(10L);
        long result4 = cal.factorial(10L);
//최초 한번만 연산, 나머지는 캐시사용
        System.out.printf("cal : %d%n", result2);
        System.out.printf("cal : %d%n", result3);
        System.out.printf("cal : %d%n", result4);
        ctx.close();
    }
}
