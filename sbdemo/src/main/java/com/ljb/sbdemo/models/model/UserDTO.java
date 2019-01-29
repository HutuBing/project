package com.ljb.sbdemo.models.model;


import com.ljb.sbdemo.models.enums.DeleteFlagEunm;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "user")
public class UserDTO {

    @Id
    @GeneratedValue(generator="UUID")
    private String id;
    private String account;
    private String password;
    private String name;
    private Integer age;
    private String birth;
    private String createTime;
    private String updateTime;

}
