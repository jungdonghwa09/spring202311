package config;

import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.format.DateTimeFormatter;

@Configuration
public class AppCtx3 {

    //@Primary
    @Bean
    public MemberDao memberDao(){
        return new MemberDao();
    }
/*
    @Bean
    public MemberDao memberDao2(){
        return new MemberDao();
    }
*/
    //아래의 Bean을 지우면 regDtStr은 null이나온다, 컨테이너에서 regDtStr을 관리안해줌
    @Bean
    public DateTimeFormatter formatter(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH :mm");
        return formatter;
    }
}
