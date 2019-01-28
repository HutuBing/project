package com.ljb.sbdemo.controller;

import com.ljb.sbdemo.common.response.ResultObj;
import com.ljb.sbdemo.models.model.User;
import com.ljb.sbdemo.models.params.UserRegisterParam;
import com.ljb.sbdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userRegister")
    public ResultObj<String> userRegister(UserRegisterParam param){

        return ResultObj.success(null);
    }

    @RequestMapping(value = "/showUser")
    @ResponseBody
    public User toIndex(HttpServletRequest request, Model model){
        String id = request.getParameter("id");
        User user = this.userService.getUserById(id);
        return user;
    }
}
