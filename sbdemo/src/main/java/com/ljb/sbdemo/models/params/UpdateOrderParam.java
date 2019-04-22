package com.ljb.sbdemo.models.params;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "更新订单入参")
public class UpdateOrderParam {

    @ApiModelProperty(value = "订单ID", required = true, dataType = "String")
    private String orderId;

}
