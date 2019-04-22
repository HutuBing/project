package com.ljb.sbdemo.models.model;

import lombok.Data;

@Data
public class ShopCartCommodity {

    private String commodityId;
    private String imageUrl;
    private String name;
    private String price;
    private String num;
    private String totalPrice;

}
