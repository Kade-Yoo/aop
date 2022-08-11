# AOP Study

## Target
- Aspect를 적용시킬 곳
```
@Around("execution(* com.example.aop.service.EventService.*(..))")
```
## Advice
- 어떤 일을 해야할지에 대한 것
```
public Object calculateProcessTime(ProceedingJoinPoint pjp) throws Throwable {
    long begin = System.currentTimeMillis();
    ... 
    System.out.println(System.currentTimeMillis() - begin);
    return retVal;
}
```
## JointPoint
- Advice가 실행되는 곳
```
public Object calculateProcessTime(ProceedingJoinPoint pjp) throws Throwable {
    ...
    Object retVal = pjp.proceed();
    ...
    return retVal;
}
```
## PointCut
- JointPoint의 상세한 내용
