package com.ljb.sbdemo.dao;

import com.ljb.sbdemo.models.model.Order;
import com.ljb.sbdemo.models.model.OrderDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface OrderMapper extends Mapper<Order> {

    List<OrderDTO> getOrderList(@Param("account")String account);

}
