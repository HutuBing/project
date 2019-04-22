package com.ljb.sbdemo.models.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "创建订单入参")
public class CreateOrderParam {

    @ApiModelProperty(value = "用户ID", required = true, dataType = "String")
    private String userId;
    @ApiModelProperty(value = "商品ID", required = true, dataType = "String")
    private String commodityId;
    @ApiModelProperty(value = "商品数量", required = true, dataType = "String")
    private String num;
    @ApiModelProperty(value = "收货地址", required = true, dataType = "String")
    private String address;
    @ApiModelProperty(value = "收货名", required = true, dataType = "String")
    private String name;
    @ApiModelProperty(value = "收货号码", required = true, dataType = "String")
    private String phone;

}
