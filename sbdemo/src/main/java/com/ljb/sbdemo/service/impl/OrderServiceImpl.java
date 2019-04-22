package com.ljb.sbdemo.service.impl;

import com.ljb.sbdemo.common.response.ResultObj;
import com.ljb.sbdemo.dao.OrderMapper;
import com.ljb.sbdemo.models.enums.OrderStatusEnum;
import com.ljb.sbdemo.models.model.OrderDTO;
import com.ljb.sbdemo.models.params.CreateOrderParam;
import com.ljb.sbdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.transform.Result;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Override
    public List<OrderDTO> getOrderList(String userId){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setUserId(userId);
        return orderMapper.select(orderDTO);
    }

    public String createOrder(CreateOrderParam param){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setCommodityId(param.getCommodityId());
        orderDTO.setNum(Integer.parseInt(param.getNum()));
        orderDTO.setAddress(param.getAddress());
        orderDTO.setStatus(OrderStatusEnum.NO_FINISH);
        orderDTO.setUserId(param.getUserId());
        if(orderMapper.insert(orderDTO)>0)
            return "ok";
        return "fail";
    }

    public String updateOrder(String orderId){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(orderId);
        orderDTO.setStatus(OrderStatusEnum.FINISH);
        if(orderMapper.updateByPrimaryKey(orderDTO)>0)
            return "ok";
        return "fail";
    }
}
