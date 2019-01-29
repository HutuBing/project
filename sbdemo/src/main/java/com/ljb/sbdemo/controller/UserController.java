package com.ljb.sbdemo.controller;

import com.ljb.sbdemo.common.response.ResultObj;
import com.ljb.sbdemo.models.model.UserDTO;
import com.ljb.sbdemo.models.params.UserRegisterParam;
import com.ljb.sbdemo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    @ApiOperation(value = "用户注册", notes = "用户注册", response = String.class)
    public ResultObj<String> userRegister(@RequestBody UserRegisterParam param){
        if(userService.userRegister(param) == true) {
            return ResultObj.success("注册成功");
        }
        return ResultObj.parameterError("该帐号已注册");
    }

    @RequestMapping(value = "/showUser", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息", response = UserDTO.class)
    public UserDTO showUser(@RequestBody String id){
        UserDTO userDTO = this.userService.getUserById(id);
        return userDTO;
    }
}
