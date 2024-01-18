package com.rwto.springbootstudy.application;

import com.rwto.springbootstudy.processor.BeanPostProcessorTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @author renmw
 * @create 2023/12/29 17:10
 **/
@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = BeanPostProcessorTest.class))
public class MvcApplication {
    public static void main(String[] args) {
        SpringApplication.run(MvcApplication.class,args);
    }
}
