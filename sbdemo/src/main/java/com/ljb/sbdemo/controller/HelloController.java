package com.ljb.sbdemo.controller;

import com.ljb.sbdemo.models.model.UserDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    @RequestMapping(value = "/sayHello", method = RequestMethod.POST)
    public String sayHello(){
        return "hello springboot";
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public UserDTO getUser(){
        UserDTO u = new UserDTO();
        u.setId("testId");
        u.setName("昵称");
        return u;
    }
}
