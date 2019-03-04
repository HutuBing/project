package com.ljb.sbdemo.service.impl;

import com.ljb.sbdemo.dao.CommodityMapper;
import com.ljb.sbdemo.models.model.Commodity;
import com.ljb.sbdemo.service.CommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    CommodityMapper commodityMapper;
    @Override
    public List<Commodity> getCommodityList(String type) {

        return commodityMapper.selectAll();

    }
}
