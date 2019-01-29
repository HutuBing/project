package com.ljb.sbdemo.models.params;

import lombok.Data;

import java.util.Date;

@Data
public class UserRegisterParam {

    private String account;

    private String password;

    private String userName;

    private String phone;

    private String age;

    private String birth;

    private String sex;

}
