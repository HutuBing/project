package com.ljb.sbdemo.models.model;

import com.ljb.sbdemo.models.enums.DeleteFlagEunm;
import lombok.Data;

import java.util.Date;

@Data
public class UserQueryRecord {

    private String id;
    private String productId;
    private String userId;
    private Date queryTime;
    private Date deadline;      //券码结束时间
    private DeleteFlagEunm deleteFlag;
    private Date createTime;
    private Date updateTime;

}
