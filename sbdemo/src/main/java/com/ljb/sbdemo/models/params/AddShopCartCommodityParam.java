package com.ljb.sbdemo.models.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "添加购物车商品入参")
public class AddShopCartCommodityParam {

    @ApiModelProperty(value = "用户帐号", required = true, dataType = "String")
    private String account;
    @ApiModelProperty(value = "商品ID", required = true, dataType = "String")
    private String commodityId;
    @ApiModelProperty(value = "商品数量", required = true, dataType = "String")
    private String num;

}
