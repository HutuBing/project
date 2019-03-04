package com.ljb.sbdemo.models.model;

import com.ljb.sbdemo.models.enums.DeleteFlagEunm;
import lombok.Data;

import java.util.Date;

@Data
public class Commodity {

    private String id;
    private String name;           //商品名
    private Integer formalPrice;   //原价，单位分
    private Integer price;         //现价，单位分
    private String categoryId;    //类型Id
    private String description;    //描述
    private String imageCover;
    private String imageSecondary;

}
