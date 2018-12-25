package com.ljb.sbdemo.models.model;

import com.ljb.sbdemo.models.enums.DeleteFlagEunm;
import lombok.Data;

import java.util.Date;

@Data
public class Product {

    private String id;
    private String taobaoProductId;     //淘宝商品id
    private Integer originalPrice;      //原价，单位 分
    private Integer commission;         //佣金
    private String code;                //券码
    private Date deadline;              //过期时间
    private DeleteFlagEunm deleteFlag;
    private Date createTime;
    private Date updateTime;

}
