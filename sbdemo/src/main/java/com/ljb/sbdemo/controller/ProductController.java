package com.ljb.sbdemo.controller;

import com.ljb.sbdemo.common.response.ResultObj;
import com.ljb.sbdemo.models.params.ProductParam;
import com.ljb.sbdemo.models.result.ProductJson;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @ApiOperation(value = "获取商品列表", notes = "获取商品列表", response = ProductJson.class)
    @RequestMapping(value = "/getProductList", method = RequestMethod.POST)
    public ResultObj<List<ProductJson>> getProductList(@RequestBody ProductParam param){

        return null;
    }
}
