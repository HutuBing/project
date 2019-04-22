package com.ljb.sbdemo.controller;

import com.ljb.sbdemo.common.response.ResultObj;
import com.ljb.sbdemo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisTestController {

    @Autowired
    RedisUtil ru;
    @RequestMapping("/testRedis")
    public ResultObj<String> testRedis(){
        ru.set("testRedis","hello redis");
        return ResultObj.success(ru.get("testRedis").toString());
    }

}
