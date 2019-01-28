package com.ljb.sbdemo.dao;

import com.ljb.sbdemo.models.model.User;

public interface UserDao {

    User selectByPrimaryKey(String id);
}
