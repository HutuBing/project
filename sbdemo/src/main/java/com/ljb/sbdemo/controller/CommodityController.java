package com.ljb.sbdemo.controller;

import com.ljb.sbdemo.common.response.ResultObj;
import com.ljb.sbdemo.models.model.Commodity;
import com.ljb.sbdemo.models.params.CommodityParam;
import com.ljb.sbdemo.models.params.GetUserFavoriteCommodityListParam;
import com.ljb.sbdemo.models.result.CommodityJson;
import com.ljb.sbdemo.service.CommodityService;
import com.ljb.sbdemo.util.ModelChangeUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/commodity")
public class CommodityController {

    @Autowired
    CommodityService commodityService;

    @ApiOperation(value = "获取商品列表", notes = "获取商品列表", response = CommodityJson.class)
    @RequestMapping(value = "/getCommodityList", method = RequestMethod.POST)
    public ResultObj<List<CommodityJson>> getCommodityList(@RequestBody CommodityParam param){
        List<Commodity> commodityList = commodityService.getCommodityList(param);
        List<CommodityJson> result = ModelChangeUtil.changeToCommodityJson(commodityList);
        return ResultObj.success(result);
    }

    @ApiOperation(value = "获取商品信息", notes = "获取商品信息", response = CommodityJson.class)
    @RequestMapping(value = "/getCommodityInfo", method = RequestMethod.POST)
    public ResultObj<CommodityJson> getCommodityInfo(@RequestBody CommodityParam param){
        List<Commodity> commodityList = commodityService.getCommodityList(param);
        List<CommodityJson> result = ModelChangeUtil.changeToCommodityJson(commodityList);
        return ResultObj.success((result != null && result.size() > 0)?result.get(0) : null);
    }

    @ApiOperation(value = "获取首页猜你喜欢商品列表", notes = "获取首页猜你喜欢商品列表", response = CommodityJson.class)
    @RequestMapping(value = "/getUserFavoriteCommodityList", method = RequestMethod.POST)
    public ResultObj<CommodityJson> getUserFavoriteCommodityList(@RequestBody GetUserFavoriteCommodityListParam param){
        List<Commodity> commodityList = commodityService.getUserFavoriteCommodityList(param);
        List<CommodityJson> result = ModelChangeUtil.changeToCommodityJson(commodityList);
        return ResultObj.success((result != null && result.size() > 0)?result.get(0) : null);
    }
}
