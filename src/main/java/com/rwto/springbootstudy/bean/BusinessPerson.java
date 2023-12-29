package com.rwto.springbootstudy.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author renmw
 * @create 2023/12/26 18:27
 **/

/**
 * singleton 单例 默认值，一个容器一个类只有一个实例
 * prototype 原型， 每次getBean 都产生一个新的实例
 *
 * Spring Web:
 * session 会话  单次会话只有一个实例
 * application Web工程的生命周期，其实和单例一样
 * request 每次请求一个实例
 * globalSession
 */
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class BusinessPerson implements BeanNameAware, BeanFactoryAware, EnvironmentAware,ApplicationContextAware, InitializingBean, DisposableBean {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()+"】setBeanFactory");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】destroy");
    }

    @PreDestroy
    public void destroy1() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】destroy1");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【"+this.getClass().getSimpleName()+"】afterPropertiesSet");
    }

    @PostConstruct
    public void init(){
        System.out.println("【"+this.getClass().getSimpleName()+"】init");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【"+this.getClass().getSimpleName()+"】setApplicationContext");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("【"+this.getClass().getSimpleName()+"】setBeanName");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("【"+this.getClass().getSimpleName()+"】setEnvironment");
    }
}
