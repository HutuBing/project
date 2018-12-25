package com.ljb.sbdemo.models.model;


import com.ljb.sbdemo.models.enums.DeleteFlagEunm;
import lombok.Data;

import java.util.Date;

@Data
public class User {

    private String id;
    private String wechatId;
    private String taobaoId;
    private String parentId;
    private String nickName;
    private Integer balance;        //单位分
    private DeleteFlagEunm deleteFlag;
    private Date createTime;
    private Date updateTime;

}
