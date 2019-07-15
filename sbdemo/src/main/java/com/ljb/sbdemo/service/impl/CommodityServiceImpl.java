package com.ljb.sbdemo.service.impl;

import com.ljb.sbdemo.dao.CommodityMapper;
import com.ljb.sbdemo.dao.OrderMapper;
import com.ljb.sbdemo.models.model.Commodity;
import com.ljb.sbdemo.models.model.Order;
import com.ljb.sbdemo.models.params.CommodityParam;
import com.ljb.sbdemo.models.params.GetUserFavoriteCommodityListParam;
import com.ljb.sbdemo.models.result.CommodityJson;
import com.ljb.sbdemo.service.CommodityService;
import com.ljb.sbdemo.util.MyStringUtil;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    CommodityMapper commodityMapper;
    @Autowired
    OrderMapper orderMapper;

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

        return commodityMapper.getIndexRelateCommodityList(param.getAccount());

    }

    @Override
    public List<Commodity> getRelateCommodityList(String commodityId){
        return commodityMapper.getRelateCommodityList(commodityId);
    }

    @Override
    public List<Commodity> getSellWellCommodityList(){
        return commodityMapper.getSellWellCommodityList();
    }

    @Override
    public List<CommodityJson> getSimilarCommodityList(String commodityId){
        List<CommodityJson> result = new ArrayList<>();
        Commodity temp2 = new Commodity();
        temp2.setId(commodityId);
        Commodity temp = commodityMapper.selectOne(temp2);
        List<Commodity> commodityList = commodityMapper.getSimilarCommodityList(commodityId);
        for(Commodity commodity : commodityList){
            CommodityJson json = new CommodityJson();
            json.setId(commodity.getId());
            json.setCategoryId(commodity.getCategoryId());
            json.setFormalPrice(commodity.getFormalPrice());
            json.setPrice(commodity.getPrice());
            json.setImageCover(commodity.getImageCover());
            json.setImageSecondary(commodity.getImageSecondary());
            json.setName(commodity.getName());
            int commNum = orderMapper.countCommomBuyCommodity(commodityId,commodity.getId());
            Order oa = new Order();
            Order ob = new Order();
            oa.setCommodityId(commodityId);
            ob.setCommodityId(commodity.getId());
            int numA = orderMapper.selectCount(oa);
            int numB = orderMapper.selectCount(ob);
            json.setSimilarityA((double)commNum/Math.sqrt(numA*numB) + "");
            json.setSimilarityB(1.0/(MyStringUtil.minEdit_distance(temp.getName(),commodity.getName())+1.0) + "");
            json.setSimilarity(Double.valueOf(json.getSimilarityA())*0.7+Double.valueOf(json.getSimilarityB())*0.3+"");
            result.add(json);
        }
        return result;
    }
}
