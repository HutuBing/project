package com.ljb.sbdemo.models.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "获取首页猜你喜欢商品列表")
public class GetUserFavoriteCommodityListParam {

    @ApiModelProperty(value = "用户帐号", required = true, dataType = "String")
    private String account;

}
