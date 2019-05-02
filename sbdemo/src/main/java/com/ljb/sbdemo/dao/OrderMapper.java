package com.ljb.sbdemo.dao;

import com.ljb.sbdemo.models.model.Order;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface OrderMapper extends Mapper<Order> {


}
