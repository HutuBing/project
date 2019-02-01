package com.ljb.sbdemo.models.params;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "获取用户信息入参")
public class GetUserInfoParam {

    @ApiModelProperty(value = "id", dataType = "String")
    private String id;
    @ApiModelProperty(value = "account", dataType = "String")
    private String account;

}
