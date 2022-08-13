package com.example.aop.config;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class TransactionalAspect {

    @Around(value = "@annotation(com.example.aop.annotation.Transactional)")
    public Object processTransactional(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        try {
            Object proceed = proceedingJoinPoint.proceed();
            return proceed;
        } finally {
            System.out.println("End");
        }
    }
}
