package com.ljb.sbdemo.models.params;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ProductParam {

    @ApiModelProperty(value = "商品类型", required = true, dataType = "Integer")
    private Integer type;
}
