package com.ljb.sbdemo.controller;

import com.ljb.sbdemo.common.response.ResultObj;
import com.ljb.sbdemo.models.model.Commodity;
import com.ljb.sbdemo.models.model.ShopCartCommodity;
import com.ljb.sbdemo.models.params.AddShopCartCommodityParam;
import com.ljb.sbdemo.models.params.CommodityParam;
import com.ljb.sbdemo.models.params.GetShopCartInfoParam;
import com.ljb.sbdemo.models.result.ShopCartCommodityJson;
import com.ljb.sbdemo.service.CommodityService;
import com.ljb.sbdemo.service.RedisService;
import com.ljb.sbdemo.util.ModelChangeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/shopCart")
public class ShopCartController {

    @Autowired
    RedisService redisService;
    @Autowired
    CommodityService commodityService;

    @RequestMapping(value = "/getShopCartInfo", method = RequestMethod.POST)
    public ResultObj<List<ShopCartCommodityJson>> getShopCartInfo(@RequestBody GetShopCartInfoParam param){
        List<ShopCartCommodity> shopCartCommodityList = redisService.getShopCartInfo(param);
        List<ShopCartCommodityJson> result = ModelChangeUtil.changeToShopCartCommodityJson(shopCartCommodityList);
        return ResultObj.success(result);
    }

    @RequestMapping(value = "/addShopCartCommodity", method = RequestMethod.POST)
    public ResultObj<String> addShopCartCommodity(@RequestBody AddShopCartCommodityParam param){
        CommodityParam commodityParam = new CommodityParam();
        commodityParam.setCommodityId(param.getCommodityId());
        List<Commodity> commodities = commodityService.getCommodityList(commodityParam);
        if(commodities != null && commodities.size() > 0){
            if(redisService.addShopCartCommodity(param.getAccount(),commodities.get(0).getId(),commodities.get(0).getName(), commodities.get(0).getImageCover(), param.getNum(),
                    commodities.get(0).getPrice().toString(), (commodities.get(0).getPrice()*Integer.parseInt(param.getNum()))+"")==true){
                return ResultObj.success("添加成功");
            }
        }
        return ResultObj.newResult(3406,"系统出错");
    }
}
