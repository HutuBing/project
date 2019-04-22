package com.ljb.sbdemo.models.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户购物车信息")
public class ShopCartCommodityJson {

    @ApiModelProperty(value = "商品ID", required = true, dataType = "Integer")
    private String commodityId;
    @ApiModelProperty(value = "商品图片URL", required = true, dataType = "String")
    private String imageUrl;
    @ApiModelProperty(value = "商品名称", required = true, dataType = "String")
    private String name;
    @ApiModelProperty(value = "商品单价（元）", required = true, dataType = "String")
    private String price;
    @ApiModelProperty(value = "商品数量", required = true, dataType = "String")
    private String num;
    @ApiModelProperty(value = "商品总价", required = true, dataType = "String")
    private String totalPrice;

}
