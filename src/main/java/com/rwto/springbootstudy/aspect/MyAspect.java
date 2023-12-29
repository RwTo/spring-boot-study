package com.rwto.springbootstudy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author renmw
 * @create 2023/12/27 9:55
 **/
@Aspect
@Component
@Order(1)//定义切面的执行顺序，越小优先级越高，也可以继承Ordered接口
public class MyAspect {
    //@Pointcut("@annotation(..)")
    @Pointcut("execution(* com.rwto.springbootstudy.service.HelloServiceImpl.sayHello(..))")
    public void pointCut(){
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("MyAspect before...");
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("MyAspect after...");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("MyAspect around before...");
        Object obj = joinPoint.proceed();
        System.out.println("MyAspect around after...");
        return obj;
    }

    @AfterReturning("pointCut()")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("MyAspect afterReturning...");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(JoinPoint joinPoint){
        System.out.println("MyAspect afterThrowing...");
    }

    /**
     不同版本的springboot 执行的顺序不同， afterReturning 和 around after
     2.7.8版本
     MyAspect around before...
     MyAspect before...
     hello! 1
     MyAspect afterReturning...
     MyAspect after...
     MyAspect around after...

     2.0.0 版本
     MyAspect around before...
     MyAspect before...
     hello! 1
     MyAspect around after...
     MyAspect after...
     MyAspect afterReturning...
    * */
}
