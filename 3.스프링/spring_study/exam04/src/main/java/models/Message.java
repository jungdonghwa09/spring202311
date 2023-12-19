package models;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Message implements InitializingBean, DisposableBean {

    public void send(String message){
        System.out.printf("전송 메세지: %s%n", message);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        //초기화 단계에서 호출되고 실행
        System.out.println("afterProperties()실행");
    }

    @Override
    public void destroy() throws Exception {
        //스프링 컨테이너 안의 빈 소멸 전에 호출
        //자원 해제를 많이 처리
        System.out.println("destroy()!!");
    }
}
