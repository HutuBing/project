package com.ljb.sbdemo.service.impl;

import com.ljb.sbdemo.models.model.Commodity;
import com.ljb.sbdemo.models.model.ShopCartCommodity;
import com.ljb.sbdemo.models.params.AddShopCartCommodityParam;
import com.ljb.sbdemo.models.params.CommodityParam;
import com.ljb.sbdemo.models.params.GetShopCartInfoParam;
import com.ljb.sbdemo.service.RedisService;
import com.ljb.sbdemo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    RedisUtil redisUtil;

    public List<ShopCartCommodity> getShopCartInfo(GetShopCartInfoParam param){

        return (List)redisUtil.get("shopCart_" + param.getAccount());

    }

    public boolean addShopCartCommodity(String account, String commodityId, String name, String imageUrl, String num, String price, String totalPrice){

        List<ShopCartCommodity> shopCartCommodityList = (List)redisUtil.get("shopCart_" + account);
        if(shopCartCommodityList==null){
            shopCartCommodityList = new ArrayList<>();
        }
        for(int i = 0; i < shopCartCommodityList.size(); i++){
            if(shopCartCommodityList.get(i).getCommodityId().equals(commodityId)){
                shopCartCommodityList.get(i).setNum(Integer.parseInt(shopCartCommodityList.get(i).getNum())
                +Integer.parseInt(num)+"");
                return redisUtil.set("shopCart_" + account, shopCartCommodityList, 100000000);
            }
        }
        ShopCartCommodity shopCartCommodity = new ShopCartCommodity();
        shopCartCommodity.setCommodityId(commodityId);
        shopCartCommodity.setName(name);
        shopCartCommodity.setImageUrl(imageUrl);
        shopCartCommodity.setNum(num);
        shopCartCommodity.setPrice(price);
        shopCartCommodity.setTotalPrice(totalPrice);
        shopCartCommodityList.add(shopCartCommodity);
        return redisUtil.set("shopCart_" + account, shopCartCommodityList, 100000000);

    }

}
