package com.ljb.sbdemo.controller;

import com.ljb.sbdemo.common.response.ResultObj;
import com.ljb.sbdemo.models.model.Commodity;
import com.ljb.sbdemo.models.params.CommodityParam;
import com.ljb.sbdemo.models.params.GetRelateCommodityListParam;
import com.ljb.sbdemo.models.params.GetSimilarCommodityListParam;
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
    public ResultObj<List<CommodityJson>> getUserFavoriteCommodityList(@RequestBody GetUserFavoriteCommodityListParam param){
        List<Commodity> commodityList = commodityService.getUserFavoriteCommodityList(param);
        List<CommodityJson> result = ModelChangeUtil.changeToCommodityJson(commodityList);
        return ResultObj.success(result);
    }

    @ApiOperation(value = "获取相关商品", notes = "获取相关商品", response = CommodityJson.class)
    @RequestMapping(value = "/getRelateCommodityList", method = RequestMethod.POST)
    public ResultObj<List<CommodityJson>> getRelateCommodityList(@RequestBody GetRelateCommodityListParam param){
        List<Commodity> commodityList = commodityService.getRelateCommodityList(param.getCommodityId());
        List<CommodityJson> result = ModelChangeUtil.changeToCommodityJson(commodityList);
        return ResultObj.success(result);
    }

    @ApiOperation(value = "获取销量最高商品", notes = "获取销量最高商品", response = CommodityJson.class)
    @RequestMapping(value = "/getSaleWellCommodityList", method = RequestMethod.POST)
    public ResultObj<List<CommodityJson>> getSaleWellCommodityList(){
        List<Commodity> commodityList = commodityService.getSellWellCommodityList();
        List<CommodityJson> result = ModelChangeUtil.changeToCommodityJson(commodityList);
        return ResultObj.success(result);
    }

    @ApiOperation(value = "获取相似商品", notes = "获取相似商品", response = CommodityJson.class)
    @RequestMapping(value = "/getSimilarCommodityList", method = RequestMethod.POST)
    public ResultObj<List<CommodityJson>> getSimilarCommodityList(@RequestBody GetSimilarCommodityListParam param){
        List<CommodityJson> result = commodityService.getSimilarCommodityList(param.getCommodityId());
        return ResultObj.success(result);
    }

    @ApiOperation(value = "测试存储过程", notes = "测试存储过程", response = String.class)
    @RequestMapping(value = "/testProd", method = RequestMethod.POST)
    public ResultObj<String> testProd(){
        commodityService.testProd();
        return new ResultObj<>("ok");
    }
}
