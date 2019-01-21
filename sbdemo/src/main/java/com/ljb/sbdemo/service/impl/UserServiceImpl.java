package com.ljb.sbdemo.service.impl;

import com.ljb.sbdemo.models.params.UserRegisterParam;
import com.ljb.sbdemo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean userRegister(UserRegisterParam param) {
        return false;
    }
}
