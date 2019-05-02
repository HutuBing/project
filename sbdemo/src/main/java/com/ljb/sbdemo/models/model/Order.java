package com.ljb.sbdemo.models.model;

import com.ljb.sbdemo.models.enums.OrderStatusEnum;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "t_order")
public class Order {

    @Id
    private String id;
    private String commodityId;
    private String account;
    private String address;
    private Integer orderStatus;
    private Integer num;

}
