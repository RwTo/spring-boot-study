package com.rwto.springbootstudy.aspect;


/**
 * @author renmw
 * @create 2023/12/26 19:58
 **/
public class MyInterceptor implements Interceptor{
    @Override
    public boolean before() {
        System.out.println("before....");
        return true;
    }

    @Override
    public void after() {
        System.out.println("after..");
    }

    @Override
    public Object around(Invocation invocation) throws Exception {
        System.out.println("around before...");
        Object res = invocation.proceed();
        System.out.println("around after...");
        return res;
    }

    @Override
    public void afterReturning() {
        System.out.println("afterReturning...");
    }

    @Override
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }

    @Override
    public boolean userAround() {
        return true;
    }
}
