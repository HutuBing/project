package com.ljb.sbdemo.controller;

import com.ljb.sbdemo.common.response.ResultObj;
import com.ljb.sbdemo.models.params.UserRegisterParam;
import com.ljb.sbdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userRegister")
    public ResultObj<String> userRegister(UserRegisterParam param){

        return ResultObj.success(null);
    }
}
