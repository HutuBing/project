package com.ljb.sbdemo.service;

import com.ljb.sbdemo.models.model.UserDTO;
import com.ljb.sbdemo.models.params.UserRegisterParam;

public interface UserService {

    boolean userRegister(String account, String name, String password, String sex, String birth, String age, String phone);

    boolean userLogin(String account, String password);

    UserDTO getUserInfo(String id, String account);


}
