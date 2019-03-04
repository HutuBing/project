package com.ljb.sbdemo.service;

import com.ljb.sbdemo.models.model.Commodity;

import java.util.List;

public interface CommodityService {

    List<Commodity> getCommodityList(String type);

}
