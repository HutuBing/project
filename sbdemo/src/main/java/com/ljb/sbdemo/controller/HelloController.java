package com.ljb.sbdemo.controller;

import com.ljb.sbdemo.models.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping("/sayHello")
    public String sayHello(){
        return "hello springboot";
    }

    @RequestMapping("/getUser")
    public User getUser(){
        User u = new User();
        u.setId("testId");
        u.setNickName("昵称");
        u.setBalance(100);
        return u;
    }
}
