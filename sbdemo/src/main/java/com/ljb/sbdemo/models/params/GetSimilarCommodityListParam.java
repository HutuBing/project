package com.ljb.sbdemo.models.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "获取相似商品信息入参")
public class GetSimilarCommodityListParam {

    @ApiModelProperty(value = "商品ID", dataType = "String")
    private String commodityId;

}
