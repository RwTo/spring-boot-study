package com.rwto.springbootstudy.service;

import org.springframework.stereotype.Service;

/**
 * @author renmw
 * @create 2023/12/26 19:01
 **/
@Service
public class HelloServiceImpl implements HelloService{
    @Override
    public void sayHello(String name) {
        if(null == name){
            int a = 1/0;
        }
        System.out.println("hello! "+name);
    }
}
