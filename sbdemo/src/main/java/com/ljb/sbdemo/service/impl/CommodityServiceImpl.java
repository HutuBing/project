package com.ljb.sbdemo.service.impl;

import com.ljb.sbdemo.dao.CommodityMapper;
import com.ljb.sbdemo.models.model.Commodity;
import com.ljb.sbdemo.models.params.CommodityParam;
import com.ljb.sbdemo.models.params.GetUserFavoriteCommodityListParam;
import com.ljb.sbdemo.service.CommodityService;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    CommodityMapper commodityMapper;
    @Override
    public List<Commodity> getCommodityList(CommodityParam param) {
        Commodity commodity = new Commodity();
        if(!StringUtils.isNullOrEmpty(param.getType())){
            commodity.setCategoryId(param.getType());
        }
        if(!StringUtils.isNullOrEmpty(param.getCommodityId())){
            commodity.setId(param.getCommodityId());
        }
        return commodityMapper.select(commodity);

    }

    @Override
    public List<Commodity> getUserFavoriteCommodityList(GetUserFavoriteCommodityListParam param){
        return null;
    }
}
