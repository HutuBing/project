package com.ljb.sbdemo.util;

import com.ljb.sbdemo.models.model.UserDTO;
import com.ljb.sbdemo.models.result.UserInfoJson;

public class ModelChangeUtil {

    public static UserInfoJson changeUserInfo(UserDTO userDTO){
        UserInfoJson json = new UserInfoJson();
        if(userDTO == null){
            return json;
        }
        json.setId(userDTO.getId());
        json.setAccount(userDTO.getAccount());
        json.setAge(userDTO.getAge()+"");
        json.setBirth(userDTO.getBirth());
        json.setName(userDTO.getName());
        return json;
    }
}
