package com.ljb.sbdemo.service;

import com.ljb.sbdemo.models.model.UserDTO;
import com.ljb.sbdemo.models.params.UserRegisterParam;

public interface UserService {

    boolean userRegister(UserRegisterParam param);

    public UserDTO getUserById(String id);
}
