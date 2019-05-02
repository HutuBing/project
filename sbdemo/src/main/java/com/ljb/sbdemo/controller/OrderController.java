package com.ljb.sbdemo.controller;

import com.ljb.sbdemo.common.response.ResultObj;
import com.ljb.sbdemo.models.model.Order;
import com.ljb.sbdemo.models.params.CreateOrderParam;
import com.ljb.sbdemo.models.params.GetOrderListParam;
import com.ljb.sbdemo.models.params.UpdateOrderParam;
import com.ljb.sbdemo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/getOrderList", method = RequestMethod.POST)
    public ResultObj<List<Order>> getOrderList(@RequestBody GetOrderListParam param){
        return ResultObj.success(orderService.getOrderList(param.getAccount()));
    }

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public ResultObj<String> createOrder(@RequestBody CreateOrderParam param){
        return ResultObj.success(orderService.createOrder(param));
    }

    @RequestMapping(value = "/updateOrder", method = RequestMethod.POST)
    public ResultObj<String> updateOrder(@RequestBody UpdateOrderParam param){
        return ResultObj.success(orderService.updateOrder(param.getOrderId()));
    }
}
