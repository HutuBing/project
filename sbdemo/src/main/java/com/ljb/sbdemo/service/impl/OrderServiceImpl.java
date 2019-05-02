package com.ljb.sbdemo.service.impl;

import com.ljb.sbdemo.dao.OrderMapper;
import com.ljb.sbdemo.models.enums.OrderStatusEnum;
import com.ljb.sbdemo.models.model.Order;
import com.ljb.sbdemo.models.params.CreateOrderParam;
import com.ljb.sbdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;
    @Override
    public List<Order> getOrderList(String account){
        Order order = new Order();
        order.setAccount(account);
        return orderMapper.select(order);
    }

    public String createOrder(CreateOrderParam param){
        Order order = new Order();
        order.setId(UUID.randomUUID().toString().replaceAll("-",""));
        order.setCommodityId(param.getCommodityId());
        order.setNum(Integer.parseInt(param.getNum()));
        order.setAddress(param.getAddress());
        order.setOrderStatus(OrderStatusEnum.NO_FINISH.getCode());
        order.setAccount(param.getAccount());
        if(orderMapper.insert(order)>0)
            return "ok";
        return "fail";
    }

    public String updateOrder(String orderId){
        Order order = new Order();
        order.setId(orderId);
        order.setCommodityId("0004");
        order.setAccount("001");
        order.setAddress("test1");
        order.setNum(1);
        order.setOrderStatus(OrderStatusEnum.FINISH.getCode());
        if(orderMapper.updateByPrimaryKeySelective(order)>0)
            return "ok";
        return "fail";
    }
}
