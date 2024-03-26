package com.rwto.springbootstudy.controller;

import com.rw.studystarter.StarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author renmw
 * @create 2024/1/3 15:27
 **/
@Controller
public class StarterController {


    @Autowired
    private StarterService starterService;

    @ResponseBody
    @RequestMapping("starter")
    public String hello(String name){
        return starterService.sayHello(name);
    }
}
