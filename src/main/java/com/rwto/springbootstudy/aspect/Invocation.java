package com.rwto.springbootstudy.aspect;

import java.lang.reflect.Method;

/**
 * @author renmw
 * @create 2023/12/26 19:56
 **/
public class Invocation {
    private Object[] params;
    private Method method;
    private Object target;

    public Invocation(Object target,Method method, Object[] params){
        this.target = target;
        this.method = method;
        this.params = params;
    }

    public Object proceed() throws Exception{
        return method.invoke(target,params);
    }
}
