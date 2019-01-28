package com.ljb.sbdemo.service;

import com.ljb.sbdemo.models.model.User;
import com.ljb.sbdemo.models.params.UserRegisterParam;

public interface UserService {

    boolean userRegister(UserRegisterParam param);

    public User getUserById(String id);
}
