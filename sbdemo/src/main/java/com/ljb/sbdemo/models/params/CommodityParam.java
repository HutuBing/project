package com.ljb.sbdemo.models.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CommodityParam {

    @ApiModelProperty(value = "商品类型ID", required = true, dataType = "String")
    private String type;
}
