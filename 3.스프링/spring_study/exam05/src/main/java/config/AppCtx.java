package config;

import aopex.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import config.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)//하위클래스 기반의 프록시
public class AppCtx {
    @Bean
    public Calculator calculator(){
        return new RecCalculator();
    }
    @Bean
    public ProxyCache proxyCache(){
        return new ProxyCache();
    }
    @Bean
    public ProxyCalculator proxyCalculator(){
        return new ProxyCalculator();
    }

}

