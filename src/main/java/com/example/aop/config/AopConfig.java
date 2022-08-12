package com.example.aop.config;


import com.example.aop.annotation.ProcessTimeLogging;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopConfig {

    @Around(value = "execution(* com.example.aop.service.EventService.*(..))")
    public Object calculateProcessTime(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }

    /**
     * 특정 어노테이션이 있을 경우 AOP 적용
     *
     * 그런데 annotation이 Aspect와 같은 경로에 있지 않을 때는 왜 안되는걸까?
     */
    @Around(value = "@annotation(com.example.aop.annotation.ProcessTimeLogging)")
    public Object calculateProcessTimeForAnnotation(ProceedingJoinPoint pjp) throws Throwable {
        long begin = System.currentTimeMillis();
        Object retVal = pjp.proceed();
        System.out.println(System.currentTimeMillis() - begin);
        return retVal;
    }
}
