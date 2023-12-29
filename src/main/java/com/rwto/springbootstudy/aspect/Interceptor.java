package com.rwto.springbootstudy.aspect;



/**
 * @author renmw
 * @create 2023/12/26 19:54
 **/
public interface Interceptor {

    boolean before();

    void after();

    Object around(Invocation invocation) throws Exception;

    void afterReturning();

    void afterThrowing();

    /*是否使用around 方法代替原有方法*/
    boolean userAround();
}
