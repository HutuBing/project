package com.ljb.sbdemo.models.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class ProductJson {

    @ApiModelProperty(value = "商品名")
    private String name;
    @ApiModelProperty(value = "商品类型")
    private Integer type;
    @ApiModelProperty(value = "商品价格，单位（分）")
    private Integer price;
    @ApiModelProperty(value = "图片url")
    private String picUrl;

}
