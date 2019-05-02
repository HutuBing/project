package com.ljb.sbdemo.service;

import com.ljb.sbdemo.models.model.Order;
import com.ljb.sbdemo.models.params.CreateOrderParam;

import java.util.List;

public interface OrderService {

    List<Order> getOrderList(String userId);

    String createOrder(CreateOrderParam param);

    String updateOrder(String orderId);

}
