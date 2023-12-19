package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Order(1)
public class ProxyCache {

    private Map<Long, Object> cacheData = new HashMap<>();

    @Around("config.CommonPointcut.publicTarget()")
    public Object process(ProceedingJoinPoint joinPoint)throws Throwable{
        Object[] args = joinPoint.getArgs();//이건 매개변수로 투입된 인자 값-10L
        Long num = (Long)args[0];
        //왜 형변환-args가 Object타입이라서

        if(cacheData.containsKey(num)){
            System.out.println("캐시값 사용");
            return cacheData.get(num);
        }
        //나머지는 캐시값을 이용

        Object result = joinPoint.proceed();
        //캐시저장-처음 한번만 되고
        cacheData.put(num,result);
        System.out.println("캐시 저장!");


        return result;
    }

}
