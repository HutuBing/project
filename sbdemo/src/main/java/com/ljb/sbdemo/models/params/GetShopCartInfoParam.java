package com.ljb.sbdemo.models.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "获取购物车信息入参")
public class GetShopCartInfoParam {

    @ApiModelProperty(value = "用户id（暂只支持传帐号）", dataType = "String")
    private String id;
    @ApiModelProperty(value = "用户帐号account", dataType = "String")
    private String account;

}
