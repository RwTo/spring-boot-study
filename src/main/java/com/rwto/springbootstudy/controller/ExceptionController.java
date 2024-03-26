package com.rwto.springbootstudy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renmw
 * @create 2024/3/19 16:00
 **/
@RestController
public class ExceptionController {

    @RequestMapping("/exception")
    public String exceptionTest(){
        int i = 1/0;
        return "test";
    }
}
