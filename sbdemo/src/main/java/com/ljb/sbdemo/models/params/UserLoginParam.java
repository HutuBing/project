package com.ljb.sbdemo.models.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "用户登录入参")
public class UserLoginParam {

    @ApiModelProperty(value = "帐号", required = true, dataType = "String")
    private String account;
    @ApiModelProperty(value = "密码MD5加密串", required = true, dataType = "String")
    private String password;

}
