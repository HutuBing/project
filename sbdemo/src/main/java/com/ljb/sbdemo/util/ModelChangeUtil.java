package com.ljb.sbdemo.util;

import com.ljb.sbdemo.models.model.Commodity;
import com.ljb.sbdemo.models.model.ShopCartCommodity;
import com.ljb.sbdemo.models.model.UserDTO;
import com.ljb.sbdemo.models.result.CommodityJson;
import com.ljb.sbdemo.models.result.ShopCartCommodityJson;
import com.ljb.sbdemo.models.result.UserInfoJson;

import java.util.ArrayList;
import java.util.List;

public class ModelChangeUtil {

    public static UserInfoJson changeUserInfo(UserDTO userDTO){
        UserInfoJson json = new UserInfoJson();
        if(userDTO == null){
            return json;
        }
        json.setId(userDTO.getId());
        json.setAccount(userDTO.getAccount());
        json.setAge(userDTO.getAge()+"");
        json.setBirth(userDTO.getBirth());
        json.setName(userDTO.getName());
        return json;
    }

    public static List<CommodityJson> changeToCommodityJson(List<Commodity> commodityList){
        if(commodityList == null || commodityList.size() <= 0){
            return null;
        }
        List<CommodityJson> result = new ArrayList<>();
        for(Commodity commodity : commodityList){
            CommodityJson json = new CommodityJson();
            json.setId(commodity.getId());
            json.setName(commodity.getName());
            json.setFormalPrice(commodity.getFormalPrice());
            json.setPrice(commodity.getPrice());
            json.setCategoryId(commodity.getCategoryId());
            json.setImageCover(commodity.getImageCover());
            json.setImageSecondary(commodity.getImageSecondary());
            result.add(json);
        }
        return result;
    }

    public static List<ShopCartCommodityJson> changeToShopCartCommodityJson(List<ShopCartCommodity> shopCartCommodityList){
        if(shopCartCommodityList == null || shopCartCommodityList.size() <= 0){
            return null;
        }
        List<ShopCartCommodityJson> result = new ArrayList<>();
        for(ShopCartCommodity shopCartCommodity : shopCartCommodityList){
            ShopCartCommodityJson json = new ShopCartCommodityJson();
            json.setCommodityId(shopCartCommodity.getCommodityId());
            json.setName(shopCartCommodity.getName());
            json.setImageUrl(shopCartCommodity.getImageUrl());
            json.setNum(shopCartCommodity.getNum());
            json.setPrice(shopCartCommodity.getPrice());
            json.setTotalPrice(shopCartCommodity.getTotalPrice());
            result.add(json);
        }
        return result;
    }
}
