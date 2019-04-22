package com.ljb.sbdemo.models.model;

import com.ljb.sbdemo.models.enums.OrderStatusEnum;
import lombok.Data;

@Data
public class OrderDTO {

    private String id;
    private String commodityId;
    private String userId;
    private String address;
    private OrderStatusEnum status;
    private Integer num;

}
