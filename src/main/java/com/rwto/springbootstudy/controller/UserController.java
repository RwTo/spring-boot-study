package com.rwto.springbootstudy.controller;

import com.rwto.springbootstudy.pojo.User;
import com.rwto.springbootstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renmw
 * @create 2023/12/29 9:41
 **/
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser")
    public User getUser(Long id){
        return userService.getUser(id);
    }


    @RequestMapping("addUser")
    public Integer addUser(User user){
        return userService.insertUser(user);
    }
}
