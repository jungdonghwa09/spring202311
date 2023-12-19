package config;

import models.member.JoinService;
import models.member.JoinValidator;
import models.member.ListService;
import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.List;

@Configuration
@Import(value={AppCtx3.class})
public class AppCtx2 {

    @Bean
    public JoinValidator joinValidator(){
        return new JoinValidator();
    }
    @Bean
    public JoinService joinService(){
        return new JoinService();
    }
    @Bean
    public ListService listService() {
        return new ListService();
    }
    //기본생성자만 추가됨-의존성은 해결안함@Autowired로 해결
}
