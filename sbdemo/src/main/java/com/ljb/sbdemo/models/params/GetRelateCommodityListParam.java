package com.ljb.sbdemo.models.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "获取相关商品入参")
public class GetRelateCommodityListParam {

    @ApiModelProperty(value = "商品ID", dataType = "String", required = true)
    private String commodityId;

}
