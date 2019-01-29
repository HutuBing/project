package com.ljb.sbdemo.models.model;

import com.ljb.sbdemo.models.enums.DeleteFlagEunm;
import lombok.Data;

import java.util.Date;

@Data
public class ProductDTO {

    private String id;
    private String name;     //商品名
    private Integer price;  //单位分
    private Integer type;   //类型
    private String desc;    //描述
    private String url;

}
