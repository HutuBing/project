package com.ljb.sbdemo.service.impl;

import com.ljb.sbdemo.dao.UserMapper;
import com.ljb.sbdemo.models.model.UserDTO;
import com.ljb.sbdemo.models.params.UserRegisterParam;
import com.ljb.sbdemo.service.UserService;
import com.ljb.sbdemo.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean userRegister(UserRegisterParam param) {
        UserDTO userDTO = new UserDTO();
        userDTO.setAccount(param.getAccount());
        if(userMapper.selectOne(userDTO) != null){
            return false;
        }
        String now = DateUtils.date2Str(new Date(),DateUtils.DF_yyyy_MM_dd_HH_mm_ss);
        userDTO.setBirth(param.getBirth());
        userDTO.setAge(Integer.parseInt(param.getAge()));
        userDTO.setName(param.getUserName());
        userDTO.setPassword(param.getPassword());
        userDTO.setCreateTime(now);
        userDTO.setUpdateTime(now);
        if (userMapper.insert(userDTO) > 0){
            return true;
        }
        return false;
    }

    @Override
    public UserDTO getUserById(String id){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        return userMapper.selectOne(userDTO);
    }
}
