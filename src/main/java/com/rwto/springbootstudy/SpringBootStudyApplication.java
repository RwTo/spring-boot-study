package com.rwto.springbootstudy;

import com.rwto.springbootstudy.processor.BeanPostProcessorTest;
import com.rwto.springbootstudy.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;


/**SpringBoot 约定优于配置*/
/*符合注解*/
@SpringBootApplication
public class SpringBootStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStudyApplication.class, args);
    }

}
