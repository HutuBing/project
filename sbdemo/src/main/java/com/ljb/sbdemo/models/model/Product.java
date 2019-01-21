package com.ljb.sbdemo.models.model;

import com.ljb.sbdemo.models.enums.DeleteFlagEunm;
import lombok.Data;

import java.util.Date;

@Data
public class Product {

    private String id;
    private String productName;     //商品名
    private Integer price;          //单位分
    private String type;
    private DeleteFlagEunm deleteFlag;
    private Date createTime;
    private Date updateTime;

}
