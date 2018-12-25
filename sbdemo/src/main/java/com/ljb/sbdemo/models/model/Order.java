package com.ljb.sbdemo.models.model;

import com.ljb.sbdemo.models.enums.DeleteFlagEunm;
import com.ljb.sbdemo.models.enums.OrderStatusEnum;
import lombok.Data;

import java.util.Date;

@Data
public class Order {

    private String id;
    private String taobaoOrderId;
    private String userId;
    private String productId;
    private Integer originalPrice;
    private Integer actualPay;
    private Integer rebate;
    private OrderStatusEnum orderStatus;
    private DeleteFlagEunm deleteFlag;
    private Date createTime;
    private Date updateTime;

}
