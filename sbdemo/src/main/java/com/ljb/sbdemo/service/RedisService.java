package com.ljb.sbdemo.service;

import com.ljb.sbdemo.models.model.ShopCartCommodity;
import com.ljb.sbdemo.models.params.AddShopCartCommodityParam;
import com.ljb.sbdemo.models.params.GetShopCartInfoParam;

import java.util.List;

public interface RedisService {

    List<ShopCartCommodity> getShopCartInfo(GetShopCartInfoParam param);

    boolean addShopCartCommodity(String account,String commodityId, String name, String imageUrl, String num, String price, String totalPrice);

}
