package com.ljb.sbdemo.dao;

import com.ljb.sbdemo.models.model.Commodity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface CommodityMapper extends Mapper<Commodity> {

    List<Commodity> getRelateCommodityList(@Param("commodityId") String commodityId);

    List<Commodity> getIndexRelateCommodityList(@Param("account") String account);

    List<Commodity> getSellWellCommodityList();

    List<Commodity> getSimilarCommodityList(@Param("commodityId") String commodityId);

    void testProd(Map map);
}
