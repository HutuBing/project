package com.ljb.sbdemo.service.impl;

import com.ljb.sbdemo.models.model.OrderDTO;
import com.ljb.sbdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public List<OrderDTO> getOrderList(String userId){
        return null;
    }
}
