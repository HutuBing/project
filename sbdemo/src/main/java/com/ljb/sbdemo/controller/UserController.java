package com.ljb.sbdemo.controller;

import com.ljb.sbdemo.common.response.ResultObj;
import com.ljb.sbdemo.models.model.UserDTO;
import com.ljb.sbdemo.models.params.GetUserInfoParam;
import com.ljb.sbdemo.models.params.UserLoginParam;
import com.ljb.sbdemo.models.params.UserRegisterParam;
import com.ljb.sbdemo.models.result.UserInfoJson;
import com.ljb.sbdemo.service.UserService;
import com.ljb.sbdemo.util.ModelChangeUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    @ApiOperation(value = "用户注册", notes = "用户注册", response = String.class)
    public ResultObj<String> userRegister(@RequestBody UserRegisterParam param) {
        if(userService.userRegister(param.getAccount(), param.getUserName(), param.getPassword(),
                param.getSex(), param.getBirth(),param.getAge(),param.getPhone()) == true) {
            return ResultObj.success("注册成功");
        }
        return ResultObj.parameterError("该帐号已注册");
    }

    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ApiOperation(value = "用户登录", notes = "用户登录", response = String.class)
    public ResultObj<String> userLogin(@RequestBody UserLoginParam param) {
        if(userService.userLogin(param.getAccount(), param.getPassword()) == true){
            return ResultObj.success("登录成功");
        }
        else if(userService.getUserInfo("",param.getAccount()) != null){
            return ResultObj.parameterError("密码错误");
        }
        else{
            return ResultObj.parameterError("帐号不存在");
        }
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    @ApiOperation(value = "获取用户信息", notes = "获取用户信息", response = UserInfoJson.class)
    public ResultObj<UserInfoJson> getUserInfo(@RequestBody GetUserInfoParam param) {
        UserInfoJson result = new UserInfoJson();
        String id = param.getId();
        String account = param.getAccount();
        if(StringUtils.isEmpty(id) && StringUtils.isEmpty(account)){
            return ResultObj.parameterError("id和帐号至少传一个");
        }
        UserDTO userDTO = userService.getUserInfo(id, account);
        if(userDTO == null){
            return ResultObj.parameterError("该帐号不存在");
        }
        return ResultObj.success(ModelChangeUtil.changeUserInfo(userDTO));
    }
}
