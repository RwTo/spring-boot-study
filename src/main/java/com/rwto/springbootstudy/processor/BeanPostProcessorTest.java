package com.rwto.springbootstudy.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author renmw
 * @create 2023/12/26 18:34
 **/
@Component
public class BeanPostProcessorTest implements BeanPostProcessor {
    /**初始化之前执行*/
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization:【"+bean.getClass().getSimpleName()+"】【"+beanName+"】");
        return bean;
    }

    /**初始化之后执行*/
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization:【"+bean.getClass().getSimpleName()+"】【"+beanName+"】");
        return bean;
    }
}
