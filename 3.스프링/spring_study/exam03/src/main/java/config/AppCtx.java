package config;

import models.member.JoinService;
import models.member.JoinValidator;
import models.member.ListService;
import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration   //AppCtx.class로 AppCtx가 설정 클래스다 라고 알려주는 것
public class AppCtx {
    @Bean//spring이 관리할 객체라는 것을 알려주는 애노테이션
    public MemberDao memberDao(){
        return new MemberDao();
    }
    @Bean
    public JoinValidator joinValidator(){
        return new JoinValidator(memberDao());
    }
    //JoinService에서 joinvalidator가 있고,필요하다
    @Bean
    public JoinService joinService(){
        return new JoinService(memberDao(), joinValidator());
    }
    //ListService에서는 joinvalidator가 필요없음
    @Bean
    public ListService listService(){
        ListService listService = new ListService();
        listService.setMemberDao(memberDao());

        return listService;
    }
}
