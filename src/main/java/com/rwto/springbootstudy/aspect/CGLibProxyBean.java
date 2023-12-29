package com.rwto.springbootstudy.aspect;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author renmw
 * @create 2023/12/26 20:59
 **/
public class CGLibProxyBean implements MethodInterceptor {

    private Object target;
    private Interceptor interceptor;

    public static Object getProxyBean(Object target, Interceptor interceptor){
        CGLibProxyBean proxyBean = new CGLibProxyBean();
        proxyBean.interceptor= interceptor;
        proxyBean.target = target;

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(proxyBean);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
      return null;
    }
}
