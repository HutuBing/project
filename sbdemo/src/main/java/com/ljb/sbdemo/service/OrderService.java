package com.ljb.sbdemo.service;

import com.ljb.sbdemo.models.model.OrderDTO;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getOrderList(String userId);

}
