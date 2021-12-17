package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

    // hello.hellospring 하단의 모든 메소드마다 하단에 선언된 메소드가 실행되도록 변경가능하게 만들기
    @Around ( "execution(* hello.hellospring..*(..))" )
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        System.out.println( "START : " + joinPoint.toLongString() );

        try {
            return joinPoint.proceed();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println( "END : " + joinPoint.toLongString() + " " + timeMs + "ms" );
        }
    }
}
