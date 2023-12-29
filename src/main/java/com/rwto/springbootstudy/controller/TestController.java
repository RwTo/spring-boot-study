package com.rwto.springbootstudy.controller;

import com.rwto.springbootstudy.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author renmw
 * @create 2023/12/25 14:00
 **/
@Controller
public class TestController {

    @Resource
    private HelloService helloService;

    @ResponseBody
    @RequestMapping("hello")
    public void hello(String name){
        helloService.sayHello(name);
    }

}
