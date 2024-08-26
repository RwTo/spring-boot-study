package com.rwto.springbootstudy.bean;

import org.springframework.stereotype.Component;

/**
 * @author renmw
 * @create 2024/4/16 17:36
 **/
@Component
public class FirstBean {
    static {
        System.out.println("my first bean");
    }
}
