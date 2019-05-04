package com.ljb.sbdemo.service;

import com.ljb.sbdemo.models.model.Commodity;
import com.ljb.sbdemo.models.params.CommodityParam;
import com.ljb.sbdemo.models.params.GetUserFavoriteCommodityListParam;

import java.util.List;

public interface CommodityService {

    List<Commodity> getCommodityList(CommodityParam param);

    List<Commodity> getUserFavoriteCommodityList(GetUserFavoriteCommodityListParam param);

    List<Commodity> getRelateCommodityList(String commodityId);

}
