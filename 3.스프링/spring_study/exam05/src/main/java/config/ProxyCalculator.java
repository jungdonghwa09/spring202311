package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class ProxyCalculator {
    //Ant경로패턴- aopex.*(aopex 패키지의 모든 하위클래스)
    //aopex..*(aopex 패키지를 포함한 하위 패키지 전체 모든 클래스)
   // @Pointcut("execution(* aopex..*(..))")//1번
    //공통기능이 적용될 범위-Pointcut execution
    //public void publicTarget(){}//2번-비어있는 메서드(설정)
    //

    //Around를거쳐서 대신수행해줌-공통기능을 수행+핵심은 대신 수행해주는 메서드임
    //@Around("publicTarget()")//3번
    @Around("config.CommonPointcut.publicTarget()")
    //@Around("execution(*aopex..*(..))")-pointcut포함해서 3줄대신 이 한줄로
    public Object process(ProceedingJoinPoint joinPoint)throws Throwable{
        //호출한 메서드의 정보 등이 담긴 joinpoint
        //Signature getSignature()-getName()-메서드이름, toLongString()-메서드 이름 자세한 정보

        //Signature sig = joinPoint.getSignature();
        //System.out.println(sig.toLongString());
        Object[] args = joinPoint.getArgs();
        long num = (Long)args[0];
        System.out.println(num);

        System.out.println("프록시!!");
        long stime = System.nanoTime();
        try {
        //Object proceed()-핵심기능 대신 수행해주는 메서드(범용타입)
            //Object[] getArgs()-
            //Object getTarget()-핵심기능 메서드가 속해있는 객체의 참조변수
            Object result = joinPoint.proceed();//핵심기능을 대신 수행하는
            //factorial()이 호출되고 있음
            return result;
        }finally{
            long etime = System.nanoTime();//공통기능
            System.out.printf("걸린시간 : %d%n", etime-stime);
        }
    }
}
