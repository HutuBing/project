package com.ljb.sbdemo.models.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class CommodityJson {

    @ApiModelProperty(value = "商品ID")
    private String id;
    @ApiModelProperty(value = "商品名")
    private String name;
    @ApiModelProperty(value = "商品类型Id")
    private String categoryId;
    @ApiModelProperty(value = "商品原价，单位（分）")
    private Integer formalPrice;
    @ApiModelProperty(value = "商品价格，单位（分）")
    private Integer price;
    @ApiModelProperty(value = "图片url")
    private String imageCover;
    @ApiModelProperty(value = "第二张图片url")
    private String imageSecondary;

}
