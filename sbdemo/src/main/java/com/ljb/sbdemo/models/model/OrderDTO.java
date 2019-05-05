package com.ljb.sbdemo.models.model;

import lombok.Data;

@Data
public class OrderDTO {

    private String id;
    private String commodityId;
    private String account;
    private String address;
    private Integer orderStatus;
    private Integer num;
    private String imageUrl;
    private String name;
    private String price;

}
