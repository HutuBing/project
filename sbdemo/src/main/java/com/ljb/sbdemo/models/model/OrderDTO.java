package com.ljb.sbdemo.models.model;

import com.ljb.sbdemo.models.enums.OrderStatusEnum;
import lombok.Data;

@Data
public class OrderDTO {

    private String id;
    private String desc;
    private String price;
    private String address;
    private OrderStatusEnum status;
    private String url;
    private String createTime;

}
