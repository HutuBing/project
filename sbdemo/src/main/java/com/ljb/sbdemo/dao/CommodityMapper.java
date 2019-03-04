package com.ljb.sbdemo.dao;

import com.ljb.sbdemo.models.model.Commodity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface CommodityMapper extends Mapper<Commodity> {
}
