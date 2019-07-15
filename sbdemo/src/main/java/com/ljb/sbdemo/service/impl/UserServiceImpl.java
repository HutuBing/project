package com.ljb.sbdemo.service.impl;

import com.ljb.sbdemo.dao.OrderMapper;
import com.ljb.sbdemo.dao.UserMapper;
import com.ljb.sbdemo.models.model.Order;
import com.ljb.sbdemo.models.model.UserDTO;
import com.ljb.sbdemo.models.params.UserRegisterParam;
import com.ljb.sbdemo.models.result.UserInfoJson;
import com.ljb.sbdemo.service.UserService;
import com.ljb.sbdemo.util.DateUtils;
import com.ljb.sbdemo.util.ModelChangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public boolean userRegister(String account, String name, String password, String sex, String birth, String age, String phone) {
        UserDTO userDTO = new UserDTO();
        userDTO.setAccount(account);
        //检查帐号是否存在
        if(userMapper.selectOne(userDTO) != null){
            return false;
        }
        String now = DateUtils.date2Str(new Date(),DateUtils.DF_yyyy_MM_dd_HH_mm_ss);
        userDTO.setBirth(birth);
        userDTO.setAge(Integer.parseInt(age));
        userDTO.setName(name);
        userDTO.setPassword(password);
        userDTO.setCreateTime(now);
        userDTO.setUpdateTime(now);
        if (userMapper.insert(userDTO) > 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean userLogin(String account, String password){
        UserDTO userDTO = new UserDTO();
        userDTO.setAccount(account);
        userDTO.setPassword(password);
        if(userMapper.selectOne(userDTO) != null){
            return true;
        }
        return false;
    }

    @Override
    public UserDTO getUserInfo(String id, String account){
        UserDTO userDTO = new UserDTO();
        if(!StringUtils.isEmpty(id)) {
            userDTO.setId(id);
        }
        if(!StringUtils.isEmpty(account)){
            userDTO.setAccount(account);
        }
        return userMapper.selectOne(userDTO);
    }

    @Override
    public List<UserDTO> getUserList(){

        return userMapper.selectAll();

    }

    public List<UserInfoJson> getSimilarUserList(String account){
        List<UserInfoJson> result = new ArrayList<>();
        List<UserDTO> userDTOList =  userMapper.getSimilarUserList(account);
        for(UserDTO userDTO : userDTOList){
            int commomBuy = orderMapper.countCommomBuy(account,userDTO.getAccount());
            Order orderA = new Order();
            Order orderB = new Order();
            orderA.setAccount(account);
            orderB.setAccount(userDTO.getAccount());
            int accountABuy = orderMapper.selectCount(orderA);
            int accountBBuy = orderMapper.selectCount(orderB);
            UserInfoJson json = ModelChangeUtil.changeUserInfo(userDTO);
            json.setSimilarity((double)commomBuy/Math.sqrt(accountABuy*accountBBuy) + "");
            result.add(json);
        }
        return result;
    }
}
