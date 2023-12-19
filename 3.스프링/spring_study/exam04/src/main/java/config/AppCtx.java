package config;

import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
/*
@ComponentScan(value="models",
            excludeFilters=@ComponentScan.Filter(type= FilterType.ANNOTATION,
            classes= ManualBean.class))

*/
/*
@ComponentScan(value="models",
            excludeFilters = @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,
                   classes=MemberDao.class))

*/
@ComponentScan(value="models",
        excludeFilters = @ComponentScan.Filter(type=FilterType.ASPECTJ,
        pattern="models..*Dao"))
public class AppCtx {


    /*
    @Bean
    public MemberDao memberDao(){//수동등록 빈이 자동 등록 빈보다 먼저 호출-이름 동일한 빈
        System.out.println("수동 등록 빈!!");
        return new MemberDao();
    }
*/

}
