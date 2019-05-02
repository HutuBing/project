package com.ljb.sbdemo.models.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "获取订单列表入参")
public class GetOrderListParam {

    @ApiModelProperty(value = "用户帐号", required = true, dataType = "String")
    private String account;

}
