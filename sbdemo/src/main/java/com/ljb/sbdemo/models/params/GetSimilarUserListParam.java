package com.ljb.sbdemo.models.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "获取相似用户信息入参")
public class GetSimilarUserListParam {

    @ApiModelProperty(value = "用户帐号", dataType = "String")
    private String account;

}
