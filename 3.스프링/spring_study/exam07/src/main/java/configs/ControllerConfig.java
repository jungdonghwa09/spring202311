package configs;

import controllers.HelloController;
import controllers.member.MemberController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"controllers","models"})//아래의 컨트롤러들에 빈이 등록되어있게 해줌
public class ControllerConfig {
    /*
    @Bean
    public HelloController helloController(){
        return new HelloController();
    }
    @Bean
    public MemberController memberController(){
        return new MemberController();
    }

     */
}
