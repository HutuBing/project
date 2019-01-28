package com.ljb.sbdemo.service.impl;

import com.ljb.sbdemo.dao.UserDao;
import com.ljb.sbdemo.models.model.User;
import com.ljb.sbdemo.models.params.UserRegisterParam;
import com.ljb.sbdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean userRegister(UserRegisterParam param) {
        return false;
    }

    @Override
    public User getUserById(String id){
        return userDao.selectByPrimaryKey(id);
    }
}
