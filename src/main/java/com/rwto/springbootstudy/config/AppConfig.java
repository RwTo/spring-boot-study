package com.rwto.springbootstudy.config;

import com.rwto.springbootstudy.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.Resource;

/**
 * @author renmw
 * @create 2023/12/26 18:37
 **/
/*根据项目的依赖关系，尝试自动配置应用程序所需的Bean。这包括数据库连接、消息队列、Web服务器等*/
//@EnableAutoConfiguration
/*扫描注册@ConfigurationProperties注解的类*/
//@EnableConfigurationProperties
@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.rwto.springbootstudy.*")
public class AppConfig {
    @Resource
    private HelloService helloService;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        HelloService helloService = context.getBean(HelloService.class);
        helloService.sayHello("小红");
        System.out.println("===================================null==============================");
        helloService.sayHello(null);
        context.close();
    }
}
