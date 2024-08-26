package com.rwto.springbootstudy;

import com.rwto.springbootstudy.application.MyContextInitializer;
import com.rwto.springbootstudy.aspect.MyAspect;
import com.rwto.springbootstudy.controller.ExceptionController;
import com.rwto.springbootstudy.pojo.User;
import com.rwto.springbootstudy.processor.BeanPostProcessorTest;
import com.rwto.springbootstudy.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;


/**SpringBoot 约定优于配置*/
/*符合注解*/
@SpringBootApplication
public class SpringBootStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudyApplication.class, args);
    }

}
