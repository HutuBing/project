package com.ljb.sbdemo.dao;

import com.ljb.sbdemo.models.model.OrderDTO;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface OrderMapper extends Mapper<OrderDTO> {

    List<OrderDTO> getOrderList(String userId);

}
